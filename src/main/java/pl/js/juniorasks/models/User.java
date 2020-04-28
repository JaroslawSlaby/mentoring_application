package pl.js.juniorasks.models;

import java.util.Set;

public interface User {

    String getNick();

    String getEmail();

    Set<NotifyChannel> getNotifyChannels();

    void addNotifyChannel(NotifyChannel channel);

    void removeNotifyChannel(NotifyChannel channel);
}