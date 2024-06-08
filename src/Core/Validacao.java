package Core;

public class Validacao {

    public static boolean temNumerosOuCaracteresEspeciais(String texto) {
        return texto
                .chars()
                .anyMatch(c -> Character
                        .isLetter(c) || c == '.' || !Character.isLetterOrDigit(c));
    }

    public static boolean temNumeros(String texto) {
        boolean temNumeros = false;
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                temNumeros = true;
            }
        }
        return temNumeros;
    }

    public static boolean temLetras(String texto) {
        boolean temLetras = false;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                temLetras = true;
                break;
            }
        }
        return  temLetras;
    }

}
