package fr.esisar.cs312.prjcrypto;

public class Sub implements Crypto{
	
	private char[][] cle;
	
	public Sub(char [][]key) {
		this.cle = key;
	}
	
	@Override 
    public String cipher(String message)
    {
    	return sub_cipher(message,cle);
    }
    
    @Override
    public String uncipher(String message)
    {
    	return sub_uncipher(message,cle);
    }
	
	
    public static String sub_cipher(String message, char[][] cle) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();

        for (int i = 0; i < to_modif.length; i++) {
            char lettre = to_modif[i];
            if (Character.isLetter(lettre)) {
                char nouvelle_lettre;
                if (Character.isUpperCase(lettre)) {
                    nouvelle_lettre = cle[lettre - 'A'][1];
                } else {
                    nouvelle_lettre = cle[lettre - 'a'][0];
                }
                resultat[i] = nouvelle_lettre;
            } else {
                resultat[i] = lettre;
            }
        }
        return String.valueOf(resultat);
    }

    public static String sub_uncipher(String message, char[][] cle) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();

        for (int i = 0; i < to_modif.length; i++) {
            char lettre = to_modif[i];
            if (Character.isLetter(lettre)) {
                char nouvelle_lettre;
                if (Character.isUpperCase(lettre)) {
                    nouvelle_lettre = cle[lettre - 'A'][1];
                } else {
                    nouvelle_lettre = cle[lettre - 'a'][0];
                }
                resultat[i] = nouvelle_lettre;
            } else {
                resultat[i] = lettre;
            }
        }
        return String.valueOf(resultat);
    }
}