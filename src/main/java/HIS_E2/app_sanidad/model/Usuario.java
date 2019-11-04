package HIS_E2.app_sanidad.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	static String key = ""; // 128 bit key
	
	public static Cipher createCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, IOException {  
		File acceso = new File("acceso.txt");
	    BufferedReader reader = new BufferedReader(new FileReader(acceso));
	    key = reader .readLine();
	    
        aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
	    reader.close();
        return cipher;
	}
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
	
	public Usuario(String dni, String nombre, String apellidos, String contrs) throws Exception {
		super();
		this.dni = cifrar(dni);
		this.nombre = cifrar(nombre);
		this.apellidos = cifrar(apellidos);
		this.contrs = cifrar(contrs);
	}

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
