package member.mailingSystem;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public void sendMail(String from, String to, String cc, String subject, String content) {
		
		Properties props = new Properties();
		
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.auth", "true");
		
		Authenticator auth = new SMPTAuthenticator();
		Session mailSesstion = Session.getDefaultInstance(props, auth);
		
		Message msg = new MimeMessage(mailSesstion);
		
		try {
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			
			if(!cc.trim().equals("")) {
				msg.setSubject(subject);
			}
			
			msg.setText(content);
			msg.setSentDate(new Date());
			
			Transport.send(msg);
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
public void sendMail2(String from, String to, String cc, String subject, String content, String title) {
		
		Properties props = new Properties();
		
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.auth", "true");
		
		Authenticator auth = new SMPTAuthenticator();
		Session mailSesstion = Session.getDefaultInstance(props, auth);
		
		Message msg = new MimeMessage(mailSesstion);
		
		try {
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			
			if(!cc.trim().equals("")) {
				msg.setSubject(subject);
			}
			msg.setSubject(subject);
			msg.setText(content);
			msg.setSentDate(new Date());
			
			Transport.send(msg);
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
}
