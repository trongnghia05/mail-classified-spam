package com.maitrongnghia.mailproject.mailservice;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

public interface WorkingMailService {
	public boolean openMail(String hostMail, String mailStoreType, String username, String password);
	public boolean sendMail(String mailName, String message);
	public Message[] readMail() throws MessagingException;
	public Message[] readMailWithTime(String timeStart, String timeFinish);
	public boolean saveFileFromMail(MimeBodyPart part, String sender);

}
