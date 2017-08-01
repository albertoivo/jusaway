package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validações do sistema por parte do servidor.
 *
 * @author Ivo
 */
public class Validacoes {

	/**
	 * Validar E-Mail.
	 * 
	 * @param email
	 * @return true se o e-mail for válido. False, caso contrário. 
	 */
	public static boolean isEmailValid(String email) {
		if ((email == null) || (email.trim().length() == 0))
			return false;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Validar CPF.
	 * 
	 * @param cpf
	 * @return true se o cpf for válido. False, caso contrário. 
	 */
	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || (cpf.length() != 11))
			return false;

		int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	/**
	 * Validar CNPJ.
	 * 
	 * @param cnpj
	 * @return true se o cnpj for válido. False, caso contrário. 
	 */
	public static boolean isValidCNPJ(String cnpj) {
		if ((cnpj == null) || (cnpj.length() != 14))
			return false;

		int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}

	/**
	 * Calcular o dígito tanto para CPF como CNPJ.
	 * @param str
	 * @param peso
	 * @return o dígito.
	 */
	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

}
