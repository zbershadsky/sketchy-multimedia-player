package com.paziy.sketchy.users.model;


import com.paziy.sketchy.parsers.Parseable;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 07.11.12
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class User extends Parseable {
    private String uid;
    private String first_name;
    private String last_name;
    private String nickname;
    private String photo;
    private String photo_medium;
    private String photo_big;
    private String online;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto_big() {
        return photo_big;
    }

    public void setPhoto_big(String photo_big) {
        this.photo_big = photo_big;
    }

    public String getPhoto_medium() {
        return photo_medium;
    }

    public void setPhoto_medium(String photo_medium) {
        this.photo_medium = photo_medium;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
