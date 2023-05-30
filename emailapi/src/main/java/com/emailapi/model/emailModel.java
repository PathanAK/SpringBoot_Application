package com.emailapi.model;


public class emailModel {

    private String to;
    private String subject;
    private String text;

    public emailModel(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public emailModel() {

    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "emailModel{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
