package pl.js.juniorasks.usernotifiers.notifiers;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import pl.js.juniorasks.models.Notification;
import pl.js.juniorasks.models.User;

import javax.mail.internet.MimeMessage;

public class MailNotifier implements Notifier {

    private static final String ENCODING = "utf-8";
    private static final String DEFAULT_SUBJECT = "New activity!";

    private final JavaMailSender mailSender;

    public MailNotifier(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void notify(User user, Notification notification) {
        String email = user.getEmail();
        sendMail(email, notification);
    }

    private void sendMail(String email, Notification body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, ENCODING);
            helper.setTo(email);
            helper.setSubject(DEFAULT_SUBJECT);
            helper.setText(body.getHTMLRepresentation(), true);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e); //todo: add custom exception
        }
    }
}
