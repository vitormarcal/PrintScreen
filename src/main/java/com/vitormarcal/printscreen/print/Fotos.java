package com.vitormarcal.printscreen.print;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class Fotos {
	private File arq;
	private String path;
	private Integer numFoto = 0;
	private BufferedImage img;
	private Robot robo;
	private Date horaCriacao;
	private Integer delay;

	public Fotos() {
		try {
			this.robo = new Robot();
		} catch (AWTException ex) {
			Logger.getLogger(Fotos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void capturaFotos(Pasta pasta) {
		this.numFoto++;
		 this.path = pasta.getPath();
		this.img = robo.createScreenCapture(new Rectangle(Toolkit
				.getDefaultToolkit().getScreenSize()));
		this.arq = new File(path + "\\" + numFoto + "."
				+ fmtDataFoto() + ".jpg");
		this.arq = new File(path + "\\IMG-" + numFoto + fmtDataFoto() + ".jpg");
		try {
			ImageIO.write(img, "jpg", arq);
		} catch (IOException ex) {
			Logger.getLogger(Fotos.class.getName()).log(Level.SEVERE, null, ex);
		}
		this.img = null;
		this.arq = null;
		robo.delay(delay);		
	}

	public String fmtDataFoto() {
		this.horaCriacao = new Date();
		DateFormat df = new SimpleDateFormat("   HH.mm.ss");
		return df.format(horaCriacao);
	}
	
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
}