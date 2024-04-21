package fr.esisar.cs312.prjcrypto;

public class ROT13L implements Crypto{

	@Override 
    public String cipher(String message)
    {
    	return rotcipher(message);
    }
    
    @Override
    public String uncipher(String message)
    {
    	return rotdecipher(message);
    }
    
    private static char rotate(char lettre, int rotation) {
        if (Character.isLetter(lettre)) {
            int debut;
            if (Character.isUpperCase(lettre)) {
                debut = lettre - 'A';
            } else {
                debut = lettre - 'a';
            }
            int nouveau = (debut + rotation) % 26;
            if (Character.isUpperCase(lettre)) {
                return (char) (nouveau + 'A');
            } else {
                return (char) (nouveau + 'a');
            }

        } else {
            return lettre;
        }
    }

    public static String rotcipher(String message) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();

        for (int i = 0; i < to_modif.length; i++) {
            resultat[i] = rotate(to_modif[i], 13);
        }

        return String.valueOf(resultat);
    }

    public static String rotdecipher(String message) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();

        for (int i = 0; i < to_modif.length; i++) {
            resultat[i] = rotate(to_modif[i], 13);
        }
        return String.valueOf(resultat);

    }

}