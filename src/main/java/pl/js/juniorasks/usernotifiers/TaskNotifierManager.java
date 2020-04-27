package pl.js.juniorasks.usernotifiers;

import pl.js.juniorasks.models.User;

public interface TaskNotifierManager {

    void notifyUser(User user, Object notification);

}
