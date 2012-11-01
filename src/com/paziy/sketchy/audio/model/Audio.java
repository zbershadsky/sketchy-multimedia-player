package com.paziy.sketchy.audio.model;

public class Audio {
    private String aid;
    private String ownerId;
    private String artist;
    private String title;
    private String duration;
    private String url;
    private String lyricsId;
    private String album;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLyricsId() {
        return lyricsId;
    }

    public void setLyricsId(String lyricsId) {
        this.lyricsId = lyricsId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        int dur = Integer.parseInt(duration);

        return artist + " - " + title + " " + String.format("%02d", (dur / 60)) + ":" + String.format("%02d", (dur % 60));
    }
}
