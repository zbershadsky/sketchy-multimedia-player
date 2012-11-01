package com.paziy.sketchy.authentication.model;

public class AuthInfo {
	private String accessToken;
	private String userId;
	private String expiresIn;
	
	public AuthInfo() {
	}
	
	public AuthInfo(String accessToken, String userId, String expiresIn) {
		this.accessToken = accessToken;
		this.userId = userId;
		this.expiresIn = expiresIn;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "AuthInfo [accessToken=" + accessToken + ", userId=" + userId
				+ ", expiresIn=" + expiresIn + "]";
	}
	
}
