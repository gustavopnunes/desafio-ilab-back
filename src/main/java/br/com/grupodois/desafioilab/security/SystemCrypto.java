package br.com.grupodois.desafioilab.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SystemCrypto {

	
	public static String encrypt(String original) throws Exception {
		String strMinhaChave = "123456789 123456789 123456789 12"; 
		Key key = new SecretKeySpec(strMinhaChave.getBytes(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES");
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		cipher.update(original.getBytes());
		
		String originalCripto = new String(cipher.doFinal(), "UTF-8");
		
		return originalCripto;
	}
}
