package com.proj.twitter.dao;

import java.util.List;

import com.proj.twitter.model.beans.Tweet;

public interface UserTweetDao {

	public void saveUserTweets(int userId, int tweetId);
	
	public List<Tweet> getUserTweets(int userId, int pageSize, int pageNo);
	
}
