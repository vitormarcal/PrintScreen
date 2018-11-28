package com.vitormarcal.printscreen.lineargs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Searchable {

    default String find(String patternString, String token) {
        Pattern pattern = Pattern.compile(patternString);

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

}
