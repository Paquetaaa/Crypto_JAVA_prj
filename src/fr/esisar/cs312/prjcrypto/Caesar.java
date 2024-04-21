package fr.esisar.cs312.prjcrypto;

public class Caesar implements Crypto{
	
    private int decalage;
    public Caesar(int shift) {
    	this.decalage = shift;
    }
    
	@Override 
    public String cipher(String message)
    {
    	return caesar_cipher(message,decalage);
    }
    
    @Override
    public String uncipher(String message)
    {
    	return caesar_uncipher(message,decalage);
    }
	
	
	public static String caesar_cipher(String message, int decalage) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();

        for(int i = 0; i < to_modif.length; i++) {
            char lettre = to_modif[i];
            if (Character.isLetter(lettre)) {
                int debut;
                if (Character.isUpperCase(lettre)) {
                    debut = lettre - 'A';
                } else {
                    debut = lettre - 'a';
                }
                int nouveau = (debut + decalage) % 26;
                char nouvelle_lettre;
                if (Character.isUpperCase(lettre)) {
                    nouvelle_lettre = (char) (nouveau  + 'A');
                } else {
                    nouvelle_lettre = (char) (nouveau  + 'a');
                }
                resultat[i] = nouvelle_lettre;
            } else {
                resultat[i] = lettre;
            }
        }
        return String.valueOf(resultat);
    }
    public static String caesar_uncipher(String ciphered,int decalage) {
        char[] resultat = new char[ciphered.length()];
        char[] to_modif = ciphered.toCharArray();

        for(int i = 0; i < to_modif.length; i++) {
            char lettre = to_modif[i];
            if (Character.isLetter(lettre)) {
                int debut;
                if (Character.isUpperCase(lettre)) {
                    debut = lettre - 'A';
                } else {
                    debut = lettre - 'a';
                }
                int nouveau = (debut - decalage) % 26;
                if (nouveau < 0) {
                    nouveau += 26; 
                }
                char nouvelle_lettre;
                if (Character.isUpperCase(lettre)) {
                    nouvelle_lettre = (char) (nouveau  + 'A');
                } else {
                    nouvelle_lettre = (char) (nouveau  + 'a');
                }
                resultat[i] = nouvelle_lettre;
            } else {
                resultat[i] = lettre;
            }
        }
        return String.valueOf(resultat);
    }
}