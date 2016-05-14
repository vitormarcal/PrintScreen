package com.vitormarcal.printscreen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Argumento {

	private String caminho = "";
	private Integer delay = 10000;
	private Pattern pattern;

	public Argumento(String argumento) {
		separaArgumentos(argumento);
	}

	private void separaArgumentos(String argumento) {
		if (!argumento.isEmpty()) {

			String tokens[] = argumento.toString().split("-");

			for (String token : tokens) {
				if (token.toUpperCase().startsWith("P"))
					formataCaminho(token);
				if (token.toUpperCase().startsWith("D"))
					formataTempo(token);
			}
		}
	}

	private void formataTempo(String token) {
		try {
			token = buscaPorRegex("\\d+", token);
			delay = Integer.parseInt(token);
		} catch (NumberFormatException e) {
			throw new ArgumentoException("Argumento inválido!");
		}

	}

	private void formataCaminho(String token) {
		caminho = buscaPorRegex("/[\\W*\\w*\\d*]+", token);

		if (caminho.equals("inválido"))
			throw new ArgumentoException("Argumento inválido!");
	}

	private String buscaPorRegex(String padrao, String token) {
		pattern = Pattern.compile(padrao);

		Matcher matcher = pattern.matcher(token);

		boolean b = false;

		while (b = matcher.find()) {
			if (b) {
				token = matcher.group();
			} else
				token = "inválido";
		}
		return token;
	}

	public String getCaminho() {
		return caminho;
	}

	public Integer getDelay() {
		return delay;
	}
}
