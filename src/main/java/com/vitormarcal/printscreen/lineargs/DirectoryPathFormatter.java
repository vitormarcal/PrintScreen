package com.vitormarcal.printscreen.lineargs;

import com.vitormarcal.printscreen.exceptions.ArgumentoException;

public class DirectoryPathFormatter implements Formable{

    @Override
    public Object format(String token) {
        String caminho = find("/[\\W*\\w*\\d*]+", token);

        if (caminho.equals("inválido"))
            throw new ArgumentoException("Argumento inválido!");
        return caminho;
    }
}
