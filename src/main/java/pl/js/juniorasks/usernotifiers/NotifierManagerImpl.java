package pl.js.juniorasks.usernotifiers;

import pl.js.juniorasks.models.NotifyChannel;
import pl.js.juniorasks.models.User;
import pl.js.juniorasks.usernotifiers.notifiers.TaskNotifier;

import java.util.Map;

public class NotifierManagerImpl implements NotifierManager {

    private final Map<NotifyChannel, TaskNotifier> notifiers;

    public NotifierManagerImpl(Map<NotifyChannel, TaskNotifier> notifiers) {
        this.notifiers = notifiers;
    }

    @Override
    public void notifyUser(User user, Object notification) {
        user.getNotifyChannels().forEach(notifyChannel ->
                this.notifiers.get(notifyChannel).notify(user, notification));
    }
    
}
