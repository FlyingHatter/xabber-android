package com.xabber.android.data.message;

/**
 * Created by valery.miller on 17.10.17.
 */

public class ChatData {

    private String subject;
    private String accountJid;
    private String userJid;
    private boolean archived;
    private NotificationState notificationState;
    private int lastPosition;
    private boolean historyRequestedAtStart;
    private Long lastActionTimestamp;
    private int state;
    private boolean isGroupchat;
    private Long firstMessageTimestamp;

    public ChatData(String subject, String accountJid, String userJid,
                    boolean archived, NotificationState notificationState, int lastPosition,
                    boolean historyRequestedAtStart, Long lastActionTimestamp, int state,
                    boolean isGroupchat, Long firstMessageTimestamp) {
        this.subject = subject;
        this.accountJid = accountJid;
        this.userJid = userJid;
        this.archived = archived;
        this.notificationState = notificationState;
        this.lastPosition = lastPosition;
        this.historyRequestedAtStart = historyRequestedAtStart;
        this.lastActionTimestamp = lastActionTimestamp;
        this.state = state;
        this.isGroupchat = isGroupchat;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public NotificationState getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(NotificationState notificationState) {
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

    public Long getLastActionTimestamp() {
        return lastActionTimestamp;
    }

    public void setLastActionTimestamp(Long lastActionTimestamp) {
        this.lastActionTimestamp = lastActionTimestamp;
    }

    public int getLastState() {
        return state;
    }

    public void setLastState(int state) {
        this.state = state;
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
