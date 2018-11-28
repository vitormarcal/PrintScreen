package com.vitormarcal.printscreen.lineargs;

import lombok.Getter;
import lombok.NonNull;

@Getter
public enum Command {
    DIRECTORY_PATH("p", new DirectoryPathFormatter()), DELAY("d", new DelayFormatter());

    private final String command;
    private final Formable formable;

    Command(String command, Formable formable) {
        this.command = command;
        this.formable = formable;
    }

    public boolean isExecutable(@NonNull final String token) {
        if (token.isEmpty()) return false;
        return token.startsWith(this.command);
    }


}
