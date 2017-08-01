package util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidacoesTest {

	@Test
	public void cpf() {
		assertTrue(Validacoes.isValidCPF("05674711445"));
		assertFalse(Validacoes.isValidCPF("04674711445"));
	}

	@Test
	public void cnpj() {
		assertTrue(Validacoes.isValidCNPJ("33683111000107"));
		assertFalse(Validacoes.isValidCNPJ("33683111000117"));
	}

	@Test
	public void email() {
		assertTrue(Validacoes.isEmailValid("albertoivo@gmail.com"));
		assertTrue(Validacoes.isEmailValid("albertoivo@serpro.gov.br"));
		assertFalse(Validacoes.isEmailValid("albertoivo@serpro"));
		assertFalse(Validacoes.isEmailValid("albertoivo@gmail"));
		assertFalse(Validacoes.isEmailValid("albertoivo@.com"));
		assertFalse(Validacoes.isEmailValid("albertoivo@com"));
		assertFalse(Validacoes.isEmailValid("albertoivogmail.com"));
		assertFalse(Validacoes.isEmailValid("@gmail.com"));
	}

}
