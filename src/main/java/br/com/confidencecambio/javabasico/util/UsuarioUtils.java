package br.com.confidencecambio.javabasico.util;

public class UsuarioUtils {
    UsuarioUtils() {}

    public static String primeiroNome(String nome) {
        String[] nomeDividido = getNomeDivido(nome);

        return nomeDividido[0];
    }

    public static String ultimoNome(String nome) {
        String[] nomeDividido = getNomeDivido(nome);

        if(nomeDividido.length < 3) {
            return nomeDividido[nomeDividido.length-1];
        } else {
            String[] ultimoNomeArray = ArrayUtils.removeElement(0, nomeDividido, String[].class);

            String ultimoNome = StringUtils.concatToText(ultimoNomeArray);

            return ultimoNome;
        }
    }

    public static String nomeTodoMaiusculo(String nome) {
        return StringUtils.toUpperCase(nome);
    }

    public static String nomeAbreviado(String nome) {
        String[] nomeDividido = getNomeDivido(nome);

        if(nomeDividido.length < 2) {
            //nome completo por favor
        }

        String[] nomeAbreviadoArray = new String[nomeDividido.length];

        String primeiroNome = nomeDividido[0];
        nomeAbreviadoArray[0] = primeiroNome;

        int ultimaPosicao = nomeAbreviadoArray.length-1;
        String ultimoNome = nomeDividido[nomeDividido.length-1];
        nomeAbreviadoArray[ultimaPosicao] = ultimoNome;

        if(nomeDividido.length < 3 && nomeDividido.length != 1) {
            nomeAbreviadoArray[1] = nomeDividido[1].charAt(0) + ".";
        } else {
            int posicaoSegundoNome = 1;
            int posicaoPenultimoNome = nomeDividido.length-1;
            for(int i = posicaoSegundoNome, key = 1; key < posicaoPenultimoNome; i++, key++) {
                if(NameUtils.checkPreposition(nomeDividido[key])) {
                    nomeAbreviadoArray = ArrayUtils.removeElement(i, nomeAbreviadoArray, String[].class);
                    key++;
                }

                char primeiroCaractere = nomeDividido[key].charAt(0);
                nomeAbreviadoArray[i] = StringUtils.toUpperCase(primeiroCaractere + ".");
            }
        }

        String nomeAbreviado = StringUtils.concatToText(nomeAbreviadoArray);

        return nomeAbreviado;
    }

    public static String[] getNomeDivido(String nome){
        return StringUtils.splitStringBySpace(nome);
    }
}
