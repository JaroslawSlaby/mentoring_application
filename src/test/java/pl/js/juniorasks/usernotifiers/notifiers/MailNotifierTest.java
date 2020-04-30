package pl.js.juniorasks.usernotifiers.notifiers;

import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import pl.js.juniorasks.models.Mentor;
import pl.js.juniorasks.models.Notification;

import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MailNotifierTest {

    public static final String MENTOR_MAIL = "TestMentorMail";
    public static final String MESSAGE_CONTENT = "TestMessageContent";

    @Test
    void okSendingTest() {
        JavaMailSender javaMailSender = mock(JavaMailSenderImpl.class);
        Notification notification = mock(Notification.class);
        Mentor mentor = mock(Mentor.class);
        MimeMessage message = mock(MimeMessage.class);

        when(notification.getHTMLRepresentation()).thenReturn(MESSAGE_CONTENT);
        when(mentor.getEmail()).thenReturn(MENTOR_MAIL);
        when(javaMailSender.createMimeMessage()).thenReturn(message);
        Notifier notifier = new MailNotifier(javaMailSender);

        notifier.notify(mentor, notification);

        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send(message);
        verify(notification).getHTMLRepresentation();
        verify(mentor).getEmail();
    }

    @Test
    void errorTest() {
        JavaMailSender javaMailSender = mock(JavaMailSenderImpl.class);
        Notification notification = mock(Notification.class);
        Mentor mentor = mock(Mentor.class);
        MimeMessage message = mock(MimeMessage.class);

        when(notification.getHTMLRepresentation()).thenReturn(MESSAGE_CONTENT);
        when(mentor.getEmail()).thenReturn(MENTOR_MAIL);
        when(javaMailSender.createMimeMessage()).thenReturn(message);
        doThrow(RuntimeException.class).when(javaMailSender).send(message);
        Notifier notifier = new MailNotifier(javaMailSender);

        assertThrows(RuntimeException.class, () -> {
            notifier.notify(mentor, notification);

            verify(javaMailSender).createMimeMessage();
            verify(notification).getHTMLRepresentation();
            verify(mentor).getEmail();
        });
    }
}