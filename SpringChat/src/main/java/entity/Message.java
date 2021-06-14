package entity;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reply_to_id")
    private Long replyToId;

    @Column
    private String user;

    @Column
    private String text;

    @Column
    private String time;

    public void setUser(String user) {
        this.user = user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public Long getReplyToId() {
        return replyToId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReplyToId(Long replyToId) {
        this.replyToId = replyToId;
    }

}
