package pl.js.juniorasks.usernotifiers;

import pl.js.juniorasks.models.Notification;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.User;
import pl.js.juniorasks.usernotifiers.notifiers.Notifier;

public interface NotifierManager {

    Notifier getNotifier(NotifyChannel notifierType);

    void notifyUser(User user, Notification notification);

}
