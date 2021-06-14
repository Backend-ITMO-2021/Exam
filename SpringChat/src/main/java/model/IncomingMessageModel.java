package model;

public class IncomingMessageModel {
    private String user;
    private String text;
    private String replyTo;

    public IncomingMessageModel(String user,
                                String text,
                                String replyTo) {
        this.user = user;
        this.text = text;
        this.replyTo = replyTo;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
