package fr.esisar.cs312.prjcrypto;
public class Ceasar {
    
    public static String cipher(String message, int decalage){

        char[] resultat = new char[message.length()];

        // faut commencer par vérifier le décalage 
        if(decalage  < 0){
            System.out.println("Mauvais décalage");
            return null;
        }


        return String.valueOf(resultat);

    }
}