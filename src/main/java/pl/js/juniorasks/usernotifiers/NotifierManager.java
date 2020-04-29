package pl.js.juniorasks.usernotifiers;

import pl.js.juniorasks.models.Notification;
import pl.js.juniorasks.models.User;

public interface NotifierManager {

    void notifyUser(User user, Notification notification);

}
