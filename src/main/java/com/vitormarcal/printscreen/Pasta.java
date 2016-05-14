package com.vitormarcal.printscreen;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pasta {
	private File arq;
	private String path;
	private String pathPersonalizado = "";
	private Date data;

	public Pasta() {
		criaPastaRaiz();
	}

	public void criaPastaRaiz() {
		this.path = pathPersonalizado + "\\PrintScreen\\";
		this.arq = new File(path);
		this.arq.mkdirs();
	}

	public void criaSubDiretorio() {
		this.path = pathPersonalizado + "\\PrintScreen\\" + fmtDataPasta();
		this.arq = new File(path);
		this.arq.mkdirs();
	}

	String fmtDataPasta() {
		DateFormat df = new SimpleDateFormat("yyy\\MM\\dd");
		this.data = new Date();
		return df.format(this.data);
	}

	public String getPath() {
		return this.path;
	}

	public void setPathPersonalizado(String pathPersonalizado) {
		if (pathPersonalizado != null) {
			this.pathPersonalizado = pathPersonalizado;
		}

	}
}
