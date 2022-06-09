package br.com.confidencecambio.javabasico.util;

import java.util.Arrays;

public class ArrayUtils {
    ArrayUtils(){}

    public static <T, U> T[] removeElement(int index, U[] array, Class<? extends T[]> returnClass) {
        Object[] newObject = new Object[array.length - 1];

        for(int i = 0, k = 0; k < array.length; i++, k++) {
            if(k == index) {
                k++;
            }
            newObject[i] = array[k];
        }

        return Arrays.copyOf(newObject, newObject.length, returnClass);
    }
}
