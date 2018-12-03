package com.vitormarcal.printscreen.print;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class Pasta {
    private File arq;
    private String path;
    private String pathPersonalizado = "";

    public Pasta() {
        criaPastaRaiz();
    }

    private void criaPastaRaiz() {
        this.path = pathPersonalizado + "\\PrintScreen\\";
        this.arq = new File(path);
        if (this.arq.mkdirs()) {
            log.info("Criado pasta {} ", arq.toString());
        }
    }

    public void criaSubDiretorio() {
        this.path = pathPersonalizado + "\\PrintScreen\\" + fmtDataPasta();
        this.arq = new File(path);
        if (this.arq.mkdirs()) {
            log.info("Criado subdiretorio {} ", arq.toString());
        }
    }

    private String fmtDataPasta() {
        DateFormat df = new SimpleDateFormat("yyy\\MM\\dd");
        Date data = new Date();
        return df.format(data);
    }

    String getPath() {
        return this.path;
    }

    public void setPathPersonalizado(String pathPersonalizado) {
        if (pathPersonalizado != null) {
            this.pathPersonalizado = pathPersonalizado;
        }

    }
}
