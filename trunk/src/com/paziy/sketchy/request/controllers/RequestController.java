package com.paziy.sketchy.request.controllers;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 01.11.12
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
public class RequestController {
    public static HttpsURLConnection sendRequest(URL url) throws IOException {
        HttpsURLConnection result = (HttpsURLConnection) url.openConnection();

        return result;
    }
}
