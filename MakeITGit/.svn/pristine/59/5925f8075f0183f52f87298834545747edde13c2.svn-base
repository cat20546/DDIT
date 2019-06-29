package encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	/*public static void main(String[] args) {
		System.out.println(encryptSHA256("1234"));
	}*/
	public static String encryptSHA256(String str) {

		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(str.getBytes("utf8"));
		    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	}
	
	
}
