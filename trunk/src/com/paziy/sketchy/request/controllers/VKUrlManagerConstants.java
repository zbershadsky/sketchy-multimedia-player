package com.paziy.sketchy.request.controllers;

public class VKUrlManagerConstants {
	//General constants
	public static String REQUEST_BASE_URL = "https://api.vk.com/method/";
	public static String ACCESS_TOKEN = "access_token=";
	public static String AND = "&";
	public static String LOGOUT = "http://api.vk.com/oauth/logout";
	
	//Authorization
	public static String AUTH_BASE_URL = "https://oauth.vk.com/authorize?";
	public static String CLIENT_ID = "client_id=";
	public static String CLIENT_ID_VALUE = "3207610";
	public static String SCOPE = "scope=";
	public static String REDIRECT_URI = "redirect_uri=";
	public static String REDIRECT_URI_VALUE = "http://oauth.vk.com/blank.html";
	public static String DISPLAY = "display=";
	public static String RESPONSE_TYPE = "response_type=";
	public static String RESPONSE_TYPE_VALUE = "token";
	
	
	/**
	 * Enum of scopes, that application will use from user of VK
	 * @author Slayer
	 *
	 */
	enum Scope {
		friends,
		photos,
		audio,
		video,
		status,
		groups,
		messages,
		offline
	}
	
	/**
	 * Enum of views of VK authorization window
	 * @author Slayer
	 *
	 */
	enum Display {
		page, 
		popup, 
		touch, 
		wap
	}
	
	//Audio
	public static String METHOD_AUDIO = "audio.get.xml?";
	public static String AUDIO_UID = "uid";
	public static String AUDIO_GID = "gid";
	public static String AUDIO_ALBUM_ID = "album_id";
	public static String AUDIO_AIDS = "aids";
	public static String AUDIO_NEED_USER = "need_user";
	public static String AUDIO_COUNT = "count";
	public static String AUDIO_OFFSET = "offset";

    //Video
    public static String METHOD_VIDEO = "video.get.xml?";
    public static String VIDEO_VIDEOS= "videos";
    public static String VIDEO_UID = "uid";
    public static String VIDEO_GID = "gid";
    public static String VIDEO_AID = "aid";
    public static String VIDEO_WIDTH = "width";
    public static String VIDEO_COUNT = "count";
    public static String VIDEO_OFFSET = "offset";
	
}
