import com.maitrongnghia.mailproject.config.SourceType;
import com.maitrongnghia.mailproject.mailoperation.WorkingMail;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    static Logger logger = Logger.getLogger(WorkingMail.class.getName());
    final String REGEX = "<[\\w\\d@\\.]+>";

    public static void main(String[] args) throws InterruptedException, MessagingException {

        String host = SourceType.MAIL_HOST;
        String mailStoreType = SourceType.MAIL_STORE_TYPE;
        String username = SourceType.MAIL_NAME;
        String pass = SourceType.MAIL_PASS;
        WorkingMail workingMail = new WorkingMail(SourceType.PATH_LOG_FILE_PROPERTIE);
        workingMail.openMail(host, mailStoreType, username, pass);

        while (true) {
            Message[] messages = workingMail.readMail();
            for (Message message : messages) {
                logInfoMail(message);
            }
            Thread.sleep(10000);

        }
    }

    public static void logInfoMail(Message message) {
        try {
            logger.log(Level.WARNING, "Subject :{0}", message.getSubject());
            logger.log(Level.WARNING, "From :{0}", message.getFrom()[0]);
            logger.log(Level.WARNING, "Date Send :{0}", message.getSentDate());
        } catch (MessagingException e) {
            logger.log(Level.WARNING, "MessagingException :{0}", e);
        }

    }
}



