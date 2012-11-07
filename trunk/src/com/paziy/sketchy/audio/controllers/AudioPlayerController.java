package com.paziy.sketchy.audio.controllers;

import com.paziy.sketchy.audio.model.Audio;
import com.paziy.sketchy.request.controllers.RequestController;
import com.paziy.sketchy.request.controllers.VKUrlManager;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 06.11.12
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class AudioPlayerController {
    private VKUrlManager manager;

    public AudioPlayerController(VKUrlManager manager) {
        this.manager = manager;
    }

    public List<Audio> getAudios() {
        List<Audio> result = null;

        try {
            HttpsURLConnection con = RequestController.sendRequest(manager.audioGet());
            AudioRecordsParser parser = new AudioRecordsParser();
            result = parser.parse(con.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
