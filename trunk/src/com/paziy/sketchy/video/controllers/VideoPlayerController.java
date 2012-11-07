package com.paziy.sketchy.video.controllers;

import com.paziy.sketchy.controllers.PlayerController;
import com.paziy.sketchy.parsers.Parser;
import com.paziy.sketchy.request.controllers.RequestController;
import com.paziy.sketchy.request.controllers.VKUrlManager;
import com.paziy.sketchy.video.model.Video;
import com.paziy.sketchy.video.model.VideoFactory;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

public class VideoPlayerController extends PlayerController<Video>{
    public static final String WRAPPER_TAG = "video";
    private VKUrlManager manager;

    public VideoPlayerController(VKUrlManager manager) {
        super(new Parser<Video>(new VideoFactory(), WRAPPER_TAG));
        this.manager = manager;
    }

    public List<Video> getVideos() {
        List<Video> result = null;

        try {
            HttpsURLConnection con = RequestController.sendRequest(manager.videoGet());
            result = parser.parse(con.getInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
