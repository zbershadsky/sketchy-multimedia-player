package com.paziy.sketchy.controllers;

import com.paziy.sketchy.authentication.model.Authenticator;
import com.paziy.sketchy.authentication.view.LoginWindow;

public class ApplicationController {
	private static ApplicationController instance;
	
	private ApplicationController() {
	}
	
	public static ApplicationController getInstance() {
		if (instance == null) {
			instance = new ApplicationController();
		}
		
		return instance;
	}
	
	public void run() {
		Authenticator auth = new LoginWindow();
		
		System.out.println(auth.login());
	}
	
	public static void main(String[] args) {
		ApplicationController.getInstance().run();
	}
}
