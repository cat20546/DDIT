package member.mailingSystem;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMPTAuthenticator extends Authenticator {

	protected PasswordAuthentication getPasswordAuthentication() {
		String adminEmailAddr = "ddhrdmakeit@gmail.com";
		String password = "201903makeIT";
		return new PasswordAuthentication(adminEmailAddr, password);
	}
}
