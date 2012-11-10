package com.paziy.sketchy.users.controllers;

import com.paziy.sketchy.controllers.PlayerController;
import com.paziy.sketchy.request.controllers.RequestController;
import com.paziy.sketchy.request.controllers.VKUrlManager;
import com.paziy.sketchy.request.controllers.VKUrlManagerConstants;
import com.paziy.sketchy.request.model.APIParameter;
import com.paziy.sketchy.request.model.ParameterList;
import com.paziy.sketchy.video.model.Video;
import com.paziy.sketchy.users.model.User;
import com.paziy.sketchy.users.model.UserFactory;
import com.paziy.sketchy.parsers.Parser;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.List;

public class UsersController extends PlayerController<User> {
    public static final String WRAPPER_TAG = "user";
    private VKUrlManager manager;

    public UsersController(VKUrlManager manager) {
        super(new Parser<User>(new UserFactory(), WRAPPER_TAG));
        this.manager = manager;
    }

    public User getCurrerntUser() {
        User result = null;

        try {
            HttpsURLConnection con = RequestController.sendRequest(manager.getCurrentUserInfo());
            result = parser.parse(con.getInputStream()).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /*public URL getCurrenUserAvatar() {
        User result = null;

        try {
            APIParameter userParameter = new APIParameter(VKUrlManagerConstants.USERS_UIDS, manager.getUser().getUserId());
            APIParameter field

            ParameterList params = new ParameterList()
            HttpsURLConnection con = RequestController.sendRequest(manager.getCurrentUserInfo());
            result = parser.parse(con.getInputStream()).get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }  */
}
