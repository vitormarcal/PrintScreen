package com.vitormarcal.printscreen.lineargs;

import com.vitormarcal.printscreen.exceptions.ArgumentoException;

public class DelayFormatter implements Formable{

    @Override
    public Object format(String token) {
        try {
            token = find("\\d+", token);
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new ArgumentoException("Argumento inválido!");
        }
    }
}
