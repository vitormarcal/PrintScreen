package com.vitormarcal.printscreen.lineargs;

import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;

@Getter
public class Argumento {

    private String path = "";
    private Integer delay = 10_000;

    public Argumento(@NonNull String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            builder.append(arg);
        }
        separaArgumentos(builder.toString());
    }

    private void separaArgumentos(@NonNull String argumento) {
        if (!argumento.isEmpty()) {

            String tokens[] = argumento.split("-");

            setDelay(tokens);

            setPath(tokens);
        }
    }

    private void setPath(@NonNull String... tokens) {
        Arrays.stream(tokens)
                .filter(Command.DIRECTORY_PATH::isExecutable)
                .findFirst()
                .ifPresent(e -> path = (String) Command.DIRECTORY_PATH.getFormable().format(e));
    }

    private void setDelay(@NonNull String... tokens) {
        Arrays.stream(tokens)
                .filter(Command.DELAY::isExecutable)
                .findFirst()
                .ifPresent(e -> delay = (Integer) Command.DELAY.getFormable().format(e));
    }
}
