package com.proj.twitter.dao;

import java.util.List;

import com.proj.twitter.model.beans.Tweet;

/**
 * Interface for the Tweet DAO
 * @author prasheel
 *
 */
public interface TweetDao {
	
	public Tweet getTweet(int tweetId);
	
	public List<Tweet> getTweets(int userId);
	
	public int saveOrUpdate(Tweet tweet);
	
	public void delete(Tweet tweet);
	

}
