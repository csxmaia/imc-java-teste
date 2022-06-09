package br.com.confidencecambio.javabasico.util;

public class ImcUtils {

    private ImcUtils() {}

    public static Double realizarCalculoImc(double peso, double altura){
        return peso / (altura * altura);
    }
}
