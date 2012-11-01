package com.paziy.sketchy.authentication.model;

import com.paziy.sketchy.authentication.model.AuthInfo;

public interface Authenticator {
	AuthInfo login();
    void logout();
}
