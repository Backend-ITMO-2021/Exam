package model;

import java.time.LocalDateTime;

public class MessageModel implements Comparable<MessageModel> {
    private String user;
    private String text;
    private int replyTo;
    private int msgNumber;
    private LocalDateTime time;

    public MessageModel(String user,
                        String text,
                        int replyTo,
                        int msgNumber,
                        LocalDateTime time) {
        this.user = user;
        this.text = text;
        this.replyTo = replyTo;
        this.msgNumber = msgNumber;
        this.time = time;
    }

    public MessageModel(String user,
                        String text,
                        int replyTo) {
        this.user = user;
        this.text = text;
        this.replyTo = replyTo;
        this.msgNumber = -1;
        this.time = LocalDateTime.now();
    }

    public MessageModel(int messageNumber,
                        String user,
                        String text,
                        int replyTo) {
        this.user = user;
        this.text = text;
        this.replyTo = replyTo;
        this.msgNumber = messageNumber;
        this.time = LocalDateTime.now();
    }

    public MessageModel(int messageNumber,
                        String user,
                        String text) {
        this.user = user;
        this.text = text;
        this.msgNumber = messageNumber;
        this.time = LocalDateTime.now();
    }

    public MessageModel(String user,
                        String text) {
        this.user = user;
        this.text = text;
        this.replyTo = -1;
        this.msgNumber = -1;
        this.time = LocalDateTime.now();
    }

    public int getReplyTo() {
        return replyTo;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public int getMsgNumber() {
        return msgNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setMsgNumber(int msgNumber) {
        this.msgNumber = msgNumber;
    }

    public void setReplyTo(int replyTo) {
        this.replyTo = replyTo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int compareTo(MessageModel messageModel) {
        return this.getTime().compareTo(messageModel.getTime());
    }
}
