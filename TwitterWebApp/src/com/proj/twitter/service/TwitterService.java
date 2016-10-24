package com.proj.twitter.service;

import java.util.List;

import com.proj.twitter.model.beans.Tweet;
import com.proj.twitter.model.beans.User;
import com.proj.twitter.util.ErrorStatus;

public interface TwitterService {
	
	public ErrorStatus createUser(User user);
	
	public ErrorStatus followUser(int userId, int followId);
	
	public ErrorStatus unfollowUser(int userId, int followId);
	
	public ErrorStatus tweet(Tweet tweet);
	
	public User getUser(int userId);
	
	public List<Tweet> getTweets(int userId);
	
	public List<Tweet> getTweets(int userId, int pageSize, int pageNo);

}
