package pl.js.juniorasks.taskoperations.notifiers;

import pl.js.juniorasks.models.Mentee;
import pl.js.juniorasks.models.Task;

public class MailNotifier implements TaskNotifier {

    @Override
    public void notify(Mentee mentee, Task task) {
        String email = mentee.getEmail();
        sendMail(email, task);
    }

    private void sendMail(String email, Task task) {
        //todo: implement sending mails in some way
    }
}
