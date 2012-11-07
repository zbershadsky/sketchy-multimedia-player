package com.paziy.sketchy.video.controllers;

import com.paziy.sketchy.audio.controllers.AudioRecordsParser;
import com.paziy.sketchy.audio.model.Audio;
import com.paziy.sketchy.request.controllers.RequestController;
import com.paziy.sketchy.request.controllers.VKUrlManager;
import com.paziy.sketchy.video.model.Video;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 07.11.12
 * Time: 13:40
 * To change this template use File | Settings | File Templates.
 */
public class VideoPlayerController {
    private VKUrlManager manager;

    public VideoPlayerController(VKUrlManager manager) {
        this.manager = manager;
    }

    public List<Video> getVideos() {
        List<Video> result = null;

        try {
            HttpsURLConnection con = RequestController.sendRequest(manager.videoGet());
            VideoRecordsParser parser = new VideoRecordsParser();
            result = parser.parse(con.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
