package com.paziy.sketchy.authentication.controllers;


import com.paziy.sketchy.authentication.model.Authenticator;
import com.paziy.sketchy.authentication.model.AuthInfo;

public class AuthenticationController {
	private Authenticator authenticator;

    public AuthenticationController(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public AuthInfo login() {
        return authenticator.login();
    }

    public void logout() {
        authenticator.logout();
    }
}
