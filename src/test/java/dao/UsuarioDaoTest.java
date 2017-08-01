package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Usuario;
import modelo.Usuario.UsuarioBuilder;

public class UsuarioDaoTest {

	@Test
	public void build1() {
		String nome = "Ivo";
		String cpf = "05674711445";

		Usuario u = new UsuarioBuilder().setNome(nome).setCpf(cpf).build();

		assertEquals(nome, u.getNome());
		assertEquals(cpf, u.getCpf());
		assertNull(u.getCnpj());
		assertNotNull(u.getDataCadastro());
		assertNull(u.getDataAtualizacao());
	}

	@Test(expected = IllegalStateException.class)
	public void build2() {
		new UsuarioBuilder().setCpf("cpf invalido").build();
	}

	@Test(expected = IllegalStateException.class)
	public void build3() {
		new UsuarioBuilder().setCnpj("cnpj invalido").build();
	}

}
