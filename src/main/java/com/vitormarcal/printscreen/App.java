package com.vitormarcal.printscreen;

import com.vitormarcal.printscreen.lineargs.Argumento;
import com.vitormarcal.printscreen.print.Fotos;
import com.vitormarcal.printscreen.print.Pasta;

/**
 * A aplicação simplesmente gera prints e salva na pasta /PrintScreen/ a cada 60,000ms a partir
 * da raiz do disco de onde a aplicação está sendo executada.
 * <p>
 * parâmetros
 * <p>
 * -p /folder/newFolder -d 5325
 * <p>
 * -p 		usado para definir uma árvore de diretório personalizada para as imagens salvas.
 * Ex:
 * <p>
 * -p /Documentos/salvas/
 * <p>
 * Este argumento fará as capturas serem salvas a partir da raiz do disco na
 * seguinte árvore: c:\Documentos\salvas\PrinsScreen\
 * <p>
 * -d		usado para definir o delay, tempo de espera, entre uma foto e outra. o padrão é 10,000ms
 * <p>
 * Ex:
 * <p>
 * -d 20000
 * <p>
 * Fará a aplicação ter um delay de 20,000ms a cada foto tirada.
 */

public class App {
    public static void main(String[] args) {

        Argumento argumentos = new Argumento(args);


        Pasta pasta = new Pasta();
        String caminho = argumentos.getPath();
        pasta.setPathPersonalizado(caminho);


        Fotos fotos = new Fotos();
        Integer delay = argumentos.getDelay();
        fotos.setDelay(delay);


        while (true) {

            pasta.criaSubDiretorio();
            fotos.capturaFotos(pasta);
        }
    }
}
