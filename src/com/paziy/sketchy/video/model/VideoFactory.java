package com.paziy.sketchy.video.model;

import com.paziy.sketchy.parsers.ParseableFactory;

public class VideoFactory implements ParseableFactory<Video> {
    @Override
    public Video create() {
        return new Video();
    }
}
