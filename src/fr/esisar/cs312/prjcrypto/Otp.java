package fr.esisar.cs312.prjcrypto;

public class Otp implements Crypto{

	private char [] cle;
	
	public Otp(char[] key) {
		this.cle = key;
	}
	
	@Override 
    public String cipher(String message)
    {
    	return otp_cipher(message,cle);
    }
    
    @Override
    public String uncipher(String message)
    {
    	return otp_uncipher(message,cle);
    }
	
	public static  String otp_cipher(String message, char[] cle) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();

        for(int i = 0; i < to_modif.length; i++) {
        	char lettre = to_modif[i];
        	int value;
        	int new_value;
        	char nouvelle_lettre;
        	if(Character.isLetter((lettre))){
        		
        		 if (Character.isUpperCase(lettre)) {
                     value = lettre - 'A';
                     new_value = (value + (int)(cle[i]-'A')%26)%26;
                     //System.out.println("cle[i]"+ (int)(cle[i]-'A')%26);
                 	nouvelle_lettre = (char) (new_value + 'A');
                 	//System.out.println("nouvelle lettre :"+nouvelle_lettre);
                 } else {
                	 value = lettre - 'a';
                     new_value = (value + (int)(cle[i]-'a')%26)%26;
                 	nouvelle_lettre = (char) (new_value + 'a');
                 	//System.out.println("nouvelle lettre :"+nouvelle_lettre);
                 }
        		
            	resultat[i] = nouvelle_lettre;
            	
        	} else {
        		resultat[i] = lettre; // cas des espaces
       
        	}
        }
        return String.valueOf(resultat);
    }

    public static String otp_uncipher(String message, char[] cle) {
        char[] resultat = new char[message.length()];
        char[] to_modif = message.toCharArray();
        
        for(int i = 0; i < to_modif.length; i++) {
        	char lettre = to_modif[i];
        	int value;
        	int new_value;
        	char nouvelle_lettre;
        	if(Character.isLetter((lettre))){
        		
        		if(Character.isUpperCase(lettre)) {
        			value = lettre - 'A';
            		new_value = (value - (int)(cle[i]-'A')%26)%26;
            		while(new_value < 0) {
            			new_value = new_value + 26;
            		}
            		nouvelle_lettre = (char)(new_value + 'A');
        		}
        		else {
        			value = lettre - 'a';
            		new_value = (value - (int)(cle[i]-'a')%26)%26;
            		while(new_value < 0) {
            			new_value = new_value + 26;
            		}
            		nouvelle_lettre = (char)(new_value + 'a');
        		}
        		
        		
        		//System.out.println("value = "+new_value);
            	//System.out.println("lettre = "+nouvelle_lettre);
            	resultat[i] = nouvelle_lettre;
        	} else {
        		resultat[i] = lettre; // cas des espaces
       
        	}
        }
        

        return String.valueOf(resultat);
    }
}