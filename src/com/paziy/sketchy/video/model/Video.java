package com.paziy.sketchy.video.model;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 07.11.12
 * Time: 14:13
 * To change this template use File | Settings | File Templates.
 */
public class Video {
    private String vid;
    private String owner_id;
    private String title;
    private String description;
    private String duration;
    private String link;
    private String image;
    private String date;
    private String player;

    public Video(String date, String description, String duration, String image, String link, String owner_id, String player, String title, String vid) {
        this.date = date;
        this.description = description;
        this.duration = duration;
        this.image = image;
        this.link = link;
        this.owner_id = owner_id;
        this.player = player;
        this.title = title;
        this.vid = vid;
    }

    public Video() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        int dur = Integer.parseInt(duration);

        return title + " " + String.format("%02d", (dur / 60)) + ":" + String.format("%02d", (dur % 60));
    }
}
