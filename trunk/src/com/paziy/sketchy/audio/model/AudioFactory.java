package com.paziy.sketchy.audio.model;

import com.paziy.sketchy.parsers.ParseableFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 07.11.12
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
public class AudioFactory implements ParseableFactory<Audio> {

    @Override
    public Audio create() {
        return new Audio();
    }
}
