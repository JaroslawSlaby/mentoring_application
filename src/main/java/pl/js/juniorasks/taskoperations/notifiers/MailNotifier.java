package pl.js.juniorasks.taskoperations.notifiers;

import pl.js.juniorasks.models.User;

public class MailNotifier implements TaskNotifier {

    @Override
    public void notify(User user, Object body) {
        String email = user.getEmail();
        sendMail(email, body);
    }

    private void sendMail(String email, Object body) {
        //todo: implement sending mails in some way and add tests for this
    }
}
