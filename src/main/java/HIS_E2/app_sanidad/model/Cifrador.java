package HIS_E2.app_sanidad.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Cifrador {

	Base64.Encoder encoder = Base64.getEncoder();  
	Base64.Decoder decoder = Base64.getDecoder();  
	static boolean existingKey=false;
	static Cipher cipher=null;
	static Key aesKey=null;
	static String key = "";
	
public static String cifrar(String a) throws Exception {
	
		if(existingKey==false) {
			cipher=createCipher();
			existingKey=true;
		}
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(a.getBytes());
        byte[] encryptedB64=Base64.getEncoder().encode(encrypted);
        return new String(encryptedB64);
	}
	
	public static String descifrar(String string) throws Exception{
        byte[] encryptedB64=Base64.getDecoder().decode(string);

        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(encryptedB64));

        return decrypted;
	}
	
	public static Cipher createCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, IOException {  
	    key = "VE9SRkVLRVJLUExITFNSSVRQU0dJTkdOVFRIUEtST1I=";
	    key = decodeBase64(key);
	    key = decryptCaesar(key);
	    
        aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        return cipher;
	}
	
	public static String cifrarHash(String x) throws Exception{
		byte[] bytesOfMessage = x.getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		return new String(thedigest);
	}
	
	public static String decodeBase64(String texto) throws UnsupportedEncodingException {
	    byte[] archivo = Base64.getDecoder().decode(texto);
	    return new String(archivo);
	}
	
	public static String decryptCaesar(String text) throws UnsupportedEncodingException 
    { 
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String shiftKey="MTQ=";
		int shiftKeyInt=Integer.parseInt(decodeBase64(shiftKey));
		String plainText="";
		for (int i = 0; i < text.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(text.charAt(i));
            int keyVal = (charPosition - shiftKeyInt) % 62;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
	    		
    }
}