package HIS_E2.app_sanidad.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

@Document(collection = "usuario")
public class Usuario {
	@Indexed(unique=true)
	String dni;
	String nombre;
	String apellidos;
	String contrs;
	int centroSalud;
	static Base64.Encoder encoder = Base64.getEncoder();  
	static Base64.Decoder decoder = Base64.getDecoder();  
	static boolean existingKey=false;
	static Cipher cipher=null;
	static Key aesKey=null;
	
	public static Cipher createCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		String key = "Bar12345Bar12345"; // 128 bit key
        // Create key and cipher
        aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        return cipher;
	}
	public static String cifrar(String a) throws Exception {
		
        // encrypt the text
		if(existingKey==false) {
			cipher=createCipher();
			existingKey=true;
		}
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(a.getBytes());
        //byte[] encryptedB = new Binary(encrypted);
        //System.out.println(new String(encrypted));
        //descifrar(encrypted);
        byte[] encryptedB64=Base64.getEncoder().encode(encrypted);
        return new String(encryptedB64);
        
		/*
		// Encoding string  
        String str = encoder.encodeToString(a.getBytes());  
        System.out.println("Encoded string: "+str);
        return str; */
        
		/*byte[] bytesOfDni = a.getBytes(StandardCharsets.UTF_8);
		MessageDigest md = MessageDigest.getInstance("AES");
		byte[] thedigest = md.digest(bytesOfDni);
		return thedigest.toString();*/
	}
	
	public static String descifrar(String string) throws Exception{
        byte[] encryptedB64=Base64.getDecoder().decode(string);
		// decrypt the text
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(encryptedB64));
        //System.out.println(decrypted);
        return decrypted;
        /*
		// Decoding string  
        String dStr = new String(decoder.decode(encrypted));  
        System.out.println("Decoded string: "+dStr); 
        return dStr;*/
	}
	public Usuario(String dni, String nombre, String apellidos, String contrs) throws Exception {
		super();
		this.dni = cifrar(dni);
		this.nombre = cifrar(nombre);
		this.apellidos = cifrar(apellidos);
		this.contrs = cifrar(contrs);
	}

	/*public Usuario() {
		// TODO Auto-generated constructor stub
	}*/

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrs() throws Exception {
		String passw = descifrar(contrs);
		return passw;
	}

	public void setContrs(String contrs) {
		this.contrs = contrs;
	}

	public int getCentroSalud() {
		return centroSalud;
	}

	public void setCentroSalud(int centroSalud) {
		this.centroSalud = centroSalud;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrs=" + contrs
				+ ", centroSalud=" + centroSalud + "]";
	}
	
}
