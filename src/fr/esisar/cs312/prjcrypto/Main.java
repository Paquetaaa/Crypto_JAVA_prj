package fr.esisar.cs312.prjcrypto;

public class Main {
    public static void main(String[] args) {

        if (args.length < 3|| args.length > 4) {
            System.out.println("Usage: java -d|-e alg <message> [args ...]");
            System.exit(1);
        }

        String operation = args[0];
        String algorithme = args[1];
        String message = args[2];
        
        if ("rot13".equals(algorithme)) {
        	Crypto rotation = new ROT13L();
            if ("-e".equals(operation)) {
                System.out.println(rotation.cipher(message));
            } else if ("-d".equals(operation)) {
                System.out.println(rotation.uncipher(message));
            } else {
                System.out.println("Opération invalide, uilisez '-e' ou '-d'.");
                System.exit(1);
            }
        }
        if ("caesar".equals(algorithme)) {
        	
        	 if (args.length != 4) {
                 System.out.println("Il manque un paramètre");
                 System.exit(1);

             }
            Integer shift = Integer.valueOf(args[3]);
            Crypto cesar = new Caesar(shift);
            if ("-e".equals(operation)) {
            	
                System.out.println(cesar.cipher(message));
            } else if ("-d".equals(operation)) {
                System.out.println(cesar.uncipher(message));
            } else {
                System.out.println("Opération invalide, uilisez '-e' ou '-d'.");
                System.exit(1);
            }
            
        }
        if ("sub".equals(algorithme)) {
        	
        	
        	 if (args.length != 4) {
                 System.out.println("Il manque un paramètre");
                 System.exit(1);

             }
        	String keyStr = args[3];
            char[][] key = buildArray(keyStr);
            Crypto sub = new Sub(key);
            
            if ("-e".equals(operation)) {
                System.out.println(sub.cipher(message));
            } else if ("-d".equals(operation)) {
                System.out.println(sub.uncipher(message));
            } else {
                System.out.println("Opération invalide, uilisez '-e' ou '-d'.");
                System.exit(1);
            }
        }
        if ("otp".equals(algorithme)) {
        	 if (args.length != 4) {
                 System.out.println("Il manque un paramètre");
                 System.exit(1);
             }
        	 String Strkey = args[3];
        	 if(message.length() > Strkey.length()) {
        		 System.out.println("La clé n'est pas de la meme taille que le message");
                 System.exit(1);
        	 }
            
            char [] key = Strkey.toCharArray();
            Crypto otp = new Otp(key);
            
            
            if ("-e".equals(operation)) {
                System.out.println(otp.cipher(message));
            } else if ("-d".equals(operation)) {
                System.out.println(otp.uncipher(message));
            } else {
                System.out.println("Opération invalide, uilisez '-e' ou '-d'.");
                System.exit(1);
            }
            
        }
        
    }
    public static char[][] buildArray(String input) {
        // Suppression des caractères de ponctuation
        input = input.replaceAll("\\s+|\\{|\\}|\\[|\\]|,", "");
        if (input.length() != 52) {
        	System.out.println("Clé invalide");
            System.exit(1);
        }
        // Création d'un tableau 2D de dimension longueuer de la String/2 (26)
        char[][] array = new char[input.length() / 2][2];

        // Remplir le tableau
        for (int i = 0; i < input.length(); i += 2) {
            array[i / 2][0] = input.charAt(i);
            array[i / 2][1] = input.charAt(i + 1);
        }

        return array;

    }
}