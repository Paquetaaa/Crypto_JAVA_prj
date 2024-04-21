package fr.esisar.cs312.prjcrypto;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "chiffres moi ca";
		
		
		System.out.println("Test de ROT13 : ");
		
		Crypto rot13 = new ROT13L();
		String modified = rot13.cipher(message);
		String retour = rot13.uncipher(modified);
		System.out.println(modified);
		System.out.println(retour);
		
		System.out.println("Test de Caesar avec 8 : ");
		Crypto cesar = new Caesar(8);
		modified = cesar.cipher(message);
		retour = cesar.uncipher(modified);
		System.out.println(modified);
		System.out.println(retour);
		

	    System.out.println("Test de Sub avec la clé :");
	    char[][] key = {
	            {'z', 'Z'}, {'y', 'Y'}, {'x', 'X'}, {'w', 'W'}, {'v', 'V'}, {'u', 'U'}, {'t', 'T'},
	            {'s', 'S'}, {'r', 'R'}, {'q', 'Q'}, {'p', 'P'}, {'o', 'O'}, {'n', 'N'}, {'m', 'M'},
	            {'l', 'L'}, {'k', 'K'}, {'j', 'J'}, {'i', 'I'}, {'h', 'H'}, {'g', 'G'}, {'f', 'F'},
	            {'e', 'E'}, {'d', 'D'}, {'c', 'C'}, {'b', 'B'}, {'a', 'A'}
	        };

	    Crypto sub = new Sub(key);
        String messageChiffre = sub.cipher(message);
        System.out.println("Message chiffré : " + messageChiffre);

        String messageDechiffre = sub.uncipher(messageChiffre);
        System.out.println("Message déchiffré : " + messageDechiffre);
	    
	    System.out.println("Test de Vernam");
	    String cle = "WMCKL";
	    Crypto otp1 = new Otp(cle.toCharArray());
	    String petit_message = "HELLO";
	    String chiffred = otp1.cipher(petit_message);
	    System.out.println("Message chiffré : " + chiffred);
	    
	    String dechiffred = otp1.uncipher(chiffred);
	    System.out.println("Message déchiffré : " + dechiffred);
	    
	    System.out.println("Test avec une string plus longue");
	    
	    String grosse_cle =   "Xgerskhndkxjfbxkdfjnbdkjfhnbxdfbbn";
	    String gros_message = "tentes donc de me chiffrer cela";
	    Crypto otp2 = new Otp(grosse_cle.toCharArray());
	    String gros_chiffre = otp2.cipher(gros_message);
	    System.out.println("Message chiffré : " + gros_chiffre);
	    
	    String gros_dechiffred = otp2.uncipher(gros_chiffre);
	    System.out.println("Message déchiffré : " + gros_dechiffred);
	    
	    
		
	}

}