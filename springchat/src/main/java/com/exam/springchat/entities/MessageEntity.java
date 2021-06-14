package com.exam.springchat.entities;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "message_table")
public class MessageEntity {

    @Id
    @Column(name="message_id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Integer id;

    @Column(name = "message_sender")
    private String sender;

    @Column(name = "message_text")
    private String text;

    @Column(name = "message_date")
    private String date;

    @Column(name = "message_reply")
    private Integer reply;

    public MessageEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
