package pl.js.juniorasks.usernotifiers.notifiers;

import pl.js.juniorasks.models.Notification;
import pl.js.juniorasks.models.User;

public interface Notifier {
    //todo: add more notifiers
    void notify(User user, Notification notification);

    void notify(String channelCommunicationId, Notification notification);
}
