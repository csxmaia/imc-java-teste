package br.com.confidencecambio.javabasico.util;

import java.util.Locale;

public class StringUtils {
    StringUtils(){}

    public static String removeSpacesAtStartEnd(String value){
        if(value.startsWith(" ")) {
            do {
                value = value.substring(1);
            } while(value.startsWith(" "));
        }
        if(value.endsWith(" ")) {
            do {
                value = value.substring(0, value.length()-1);
            } while(value.endsWith(" "));
        }
        return value;
    }

    public static String[] splitStringBySpace(String value) {
        String [] splitted = value.split(" ");
        return splitted;
    }

    public static String toUpperCase(String value) {
        return value.toUpperCase(Locale.ROOT);
    }

    public static String concatToText(String[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < stringArray.length; i++) {
            stringBuilder.append(stringArray[i]);
            if(i != stringArray.length-1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    public static String abbreviate(String value) {
        return null;
    }
}
