package com.example.project;

public class Request {

    String from;
    String to;
    String number;
    int img;

    public Request(String from, String to, String number, int img) {
        setFrom(from);
        setTo(to);
        setNumber(number);
        setImg(img);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
