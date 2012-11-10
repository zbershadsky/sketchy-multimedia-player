package com.paziy.sketchy.request.controllers;

import java.net.MalformedURLException;
import java.net.URL;

import com.paziy.sketchy.request.controllers.VKUrlManagerConstants.Scope;
import com.paziy.sketchy.authentication.model.AuthInfo;
import com.paziy.sketchy.request.model.ParameterList;

import static com.paziy.sketchy.request.controllers.VKUrlManagerConstants.*;

public class VKUrlManager {
	private AuthInfo user;

	public VKUrlManager(AuthInfo user) {
		this.user = user;
	}

    public AuthInfo getUser() {
        return user;
    }

    private static String generateScope(Object ... scopes) {
		String result = "";
		
		for (int index = 0; index < scopes.length - 1; ++index) {
			result += scopes[index] + ",";
		}
		
		result += scopes[scopes.length - 1];
		
		return result;
	}
	
	public static URL authorization() throws MalformedURLException {
		String urlString = AUTH_BASE_URL + CLIENT_ID + CLIENT_ID_VALUE + AND + 
				SCOPE + generateScope(Scope.audio, Scope.friends, Scope.photos, Scope.video, Scope.offline) + AND +
				REDIRECT_URI + REDIRECT_URI_VALUE + AND + DISPLAY + Display.page + AND + 
				RESPONSE_TYPE + RESPONSE_TYPE_VALUE;
		
		return new URL(urlString);
	}
	
	public URL audioGet() throws MalformedURLException {
		String urlString = REQUEST_BASE_URL + METHOD_AUDIO + AND + 
				ACCESS_TOKEN + user.getAccessToken();
		
		return new URL(urlString);
	}
	
	public URL audioGet(ParameterList params) throws MalformedURLException {
		String urlString = REQUEST_BASE_URL + METHOD_AUDIO + params.toString() + AND + 
				ACCESS_TOKEN + user.getAccessToken();
		
		return new URL(urlString);
	}
	
	public URL logout() throws MalformedURLException {
		return new URL(LOGOUT);
	}

    public URL videoGet() throws MalformedURLException {
        String urlString = REQUEST_BASE_URL + METHOD_VIDEO + AND +
                ACCESS_TOKEN + user.getAccessToken();

        return new URL(urlString);
    }

    public URL videoGet(ParameterList params) throws MalformedURLException {
        String urlString = REQUEST_BASE_URL + METHOD_VIDEO + params.toString() + AND +
                ACCESS_TOKEN + user.getAccessToken();

        return new URL(urlString);
    }

    public URL getCurrentUserInfo() throws MalformedURLException {
        String urlString = REQUEST_BASE_URL + METHOD_USERS + USERS_UIDS + user.getUserId() + AND + USERS_FIELDS + AND +
                ACCESS_TOKEN + user.getAccessToken();

        return new URL(urlString);
    }

    public URL getUsersInfo(String[] users) throws MalformedURLException {
        String urlString = REQUEST_BASE_URL + METHOD_USERS + USERS_UIDS + generateScope(users) + AND +
                USERS_FIELDS + ACCESS_TOKEN + user.getAccessToken();

        return new URL(urlString);
    }
}
