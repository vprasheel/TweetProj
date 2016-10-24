package com.proj.twitter.util;

public enum ErrorCode {
	SUCCESS(0, "Success"),
	USER_CREATE_ERROR(1001, "Create User Error"),
	USER_FETCH_ERROR(1002, "Error in fetching the User"),
	USER_UPDATE_ERROR(1003, "Error in updating the User"),
	FOLLOWER_FETCH_ERROR(1004, "Error in fetching the Follower"),
	FOLLOWER_INVALID_ERROR(1004, "Invalid Follower Error"),
	TWEET_CREATE_ERROR(2001, "Create Tweet Error"),
	TWEET_FETCH_ERROR(2002, "Error in fetching the User");
	
	private final int code;
	private final String message;
	
	ErrorCode(int code, String msg){
		this.code = code;
		this.message = msg;
	}
	
	
	
}
