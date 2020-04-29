package pl.js.juniorasks.usernotifiers;

import pl.js.juniorasks.models.Notification;
import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.User;
import pl.js.juniorasks.usernotifiers.notifiers.Notifier;

import java.util.Map;

public class NotifierManagerImpl implements NotifierManager {

    private final Map<NotifyChannel, Notifier> notifiers;

    public NotifierManagerImpl(Map<NotifyChannel, Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    @Override
    public void notifyUser(User user, Notification notification) {
        user.getNotifyChannels().forEach(notifyChannel ->
                this.notifiers.get(notifyChannel).notify(user, notification));
    }
    
}
