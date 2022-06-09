package br.com.confidencecambio.javabasico.util;

public class NameUtils {

    NameUtils(){}

    public static boolean checkPreposition(String value) {
        char firstChar = value.charAt(0);
        if(value.length() <= 3 && Character.isLowerCase(firstChar)) {
            return true;
        }
        return false;
    }
}
