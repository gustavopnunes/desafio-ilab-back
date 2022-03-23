package br.com.grupodois.desafioilab.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SystemCrypto {

	
	public static String encrypt(String original) throws Exception {
		String strKey = "123456789 abcdefghi"; 
		Key key = new SecretKeySpec(strKey.getBytes(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES");
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		cipher.update(original.getBytes());
		
		return new String(cipher.doFinal(), "UTF-8");
	}
}
