package pl.js.juniorasks.usernotifiers.notifiers;

import pl.js.juniorasks.models.User;

public class MailNotifier implements Notifier {

    @Override
    public void notify(User user, Object notification) {
        String email = user.getEmail();
        sendMail(email, notification);
    }

    private void sendMail(String email, Object body) {
        //todo: implement sending mails in some way and add tests for this
    }
}
