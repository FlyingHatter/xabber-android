package com.xabber.android.data.database.realmobjects;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by valery.miller on 17.10.17.
 */

public class OldChatRealmObject extends RealmObject {

    @PrimaryKey
    @Required
    private String id;

    private String subject;
    private String accountJid;
    private String userJid;
    private int unreadCount;
    private boolean archived;
    private NotificationStateRealmObject notificationState;
    private int lastPosition;
    private boolean historyRequestedAtStart;
    private Long lastActionTimestamp;
    private int chatStateMode;
    private boolean isGroupchat;
    private Long firstMessageTimestamp;

    public OldChatRealmObject(String accountJid, String userJid) {
        this.id = accountJid + "-" + userJid;
        this.accountJid = accountJid;
        this.userJid = userJid;
    }

    public OldChatRealmObject() {
        this.id = UUID.randomUUID().toString();
    }

    public String getAccountJid() {
        return accountJid;
    }

    public void setAccountJid(String accountJid) {
        this.accountJid = accountJid;
    }

    public String getUserJid() {
        return userJid;
    }

    public void setUserJid(String userJid) {
        this.userJid = userJid;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public NotificationStateRealmObject getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(NotificationStateRealmObject notificationState) {
        this.notificationState = notificationState;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
    }

    public boolean isHistoryRequestedAtStart() {
        return historyRequestedAtStart;
    }

    public void setHistoryRequestedAtStart(boolean historyRequestedAtStart) {
        this.historyRequestedAtStart = historyRequestedAtStart;
    }

    public Long getLastActionTimestamp() {
        return lastActionTimestamp;
    }

    public void setLastActionTimestamp(Long lastActionTimestamp) {
        this.lastActionTimestamp = lastActionTimestamp;
    }

    public int getChatstateMode() {
        return chatStateMode;
    }

    public void setChatStateMode(int mode) {
        chatStateMode = mode;
    }

    public boolean isGroupchat() {
        return isGroupchat;
    }

    public void setGroupchat(boolean groupchat) {
        isGroupchat = groupchat;
    }

    public Long getFirstMessageTimestamp() {
        return firstMessageTimestamp;
    }

    public void setFirstMessageTimestamp(Long firstMessageTimestamp) {
        this.firstMessageTimestamp = firstMessageTimestamp;
    }
}
