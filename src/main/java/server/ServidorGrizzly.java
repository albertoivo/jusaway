package server;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Iniciar e parar o Servidor Grizzly.
 * 
 * @author Ivo
 *
 */
public class ServidorGrizzly implements IServidor {

	private static HttpServer server;

	public static void main(String[] args) throws IOException {

		IServidor grizzly = new ServidorGrizzly();
		grizzly.startServidor();
		System.in.read();
		grizzly.stopServidor();

	}

	public void startServidor() {
		URI uri = URI.create("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig().packages("resource");
		server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("Servidor rodando...");
	}

	public void stopServidor() {
		server.shutdown();
		System.out.println("Servidor finalizado!");
	}

}
