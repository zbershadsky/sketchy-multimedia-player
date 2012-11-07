package com.paziy.sketchy.audio.controllers;

import com.paziy.sketchy.audio.model.Audio;
import com.paziy.sketchy.audio.model.AudioFactory;
import com.paziy.sketchy.controllers.PlayerController;
import com.paziy.sketchy.parsers.Parser;
import com.paziy.sketchy.request.controllers.RequestController;
import com.paziy.sketchy.request.controllers.VKUrlManager;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

public class AudioPlayerController extends PlayerController<Audio>{
    public static final String WRAPPER_TAG = "audio";
    private VKUrlManager manager;

    public AudioPlayerController(VKUrlManager manager) {
        super(new Parser<Audio>(new AudioFactory(), WRAPPER_TAG));
        this.manager = manager;
    }

    public List<Audio> getAudios() {
        List<Audio> result = null;

        try {
            HttpsURLConnection con = RequestController.sendRequest(manager.audioGet());
            result = parser.parse(con.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
