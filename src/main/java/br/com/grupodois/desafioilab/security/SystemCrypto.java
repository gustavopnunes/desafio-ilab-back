package br.com.grupodois.desafioilab.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SystemCrypto {

	
	public static String encrypt(String original) throws Exception {
		String strMinhaChave = "123456789 123456789 123456789 12"; 
		Key minhaChave = new SecretKeySpec(strMinhaChave.getBytes(), "AES");
		
		// preciso escolher o algoritmo de Criptografia
		Cipher cipher = Cipher.getInstance("AES");
		
		// inicializando o algoritmo de criptografia
		cipher.init(Cipher.ENCRYPT_MODE, minhaChave);
		
		// agora sim vamos trabalhar a "transformação" da nossa string
		cipher.update(original.getBytes());
		
		// gero a string criptografada
		String originalCripto = new String(cipher.doFinal(), "UTF-8");
		
		return originalCripto;
	}
}
