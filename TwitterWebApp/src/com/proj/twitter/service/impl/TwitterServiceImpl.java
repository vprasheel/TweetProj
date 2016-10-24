package com.proj.twitter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.proj.twitter.dao.TweetDao;
import com.proj.twitter.dao.UserDao;
import com.proj.twitter.dao.UserFollowerDao;
import com.proj.twitter.dao.UserTweetDao;
import com.proj.twitter.model.beans.Tweet;
import com.proj.twitter.model.beans.User;
import com.proj.twitter.model.beans.UserFollower;
import com.proj.twitter.model.beans.UserTweet;
import com.proj.twitter.service.TwitterService;
import com.proj.twitter.util.ErrorCode;
import com.proj.twitter.util.ErrorStatus;

@Component("TwitterService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor= Exception.class)
public class TwitterServiceImpl implements TwitterService{
	
	@Autowired
	@Qualifier("UserDao")
	private UserDao userDao;
	
	@Autowired
	@Qualifier("TweetDao")
	private TweetDao tweetDao;
	
	@Autowired
	@Qualifier("UserFollowerDao")
	private UserFollowerDao userFollowerDao;
	
	@Autowired
	@Qualifier("UserTweetDao")
	private UserTweetDao userTweetDao;
	
	@Override
	public ErrorStatus createUser(User user){
		ErrorStatus errorStatus = new ErrorStatus();
		if(user != null){
			userDao.saveOrUpdate(user);
		}
		else{
			errorStatus.addError(ErrorCode.USER_CREATE_ERROR);
		}
		return errorStatus;
	}

	@Override
	public ErrorStatus followUser(int userId, int followId) {
		ErrorStatus errorStatus = new ErrorStatus();
		User user = userDao.getUser(userId);
		if(user == null)
			errorStatus.addError(ErrorCode.USER_FETCH_ERROR);
		User followUser = userDao.getUser(followId);
		if(followUser == null)
			errorStatus.addError(ErrorCode.FOLLOWER_FETCH_ERROR);
		userFollowerDao.saveUserFollower(userId, followId);
		
		return errorStatus;
		
	}

	@Override
	public ErrorStatus unfollowUser(int userId, int followId) {
		ErrorStatus errorStatus = new ErrorStatus();
		User user = userDao.getUser(userId);
		if(user == null)
			errorStatus.addError(ErrorCode.USER_FETCH_ERROR);
		User followUser = userDao.getUser(followId);
		if(followUser == null)
			errorStatus.addError(ErrorCode.FOLLOWER_FETCH_ERROR);
		List<UserFollower> followers = userFollowerDao.getFollowers(user.getId());
		if(followers == null)
			errorStatus.addError(ErrorCode.FOLLOWER_INVALID_ERROR);
		else
			followers.remove(followUser);
		userDao.saveOrUpdate(user);
		
		return errorStatus;
		
	}

	@Override
	public ErrorStatus tweet(Tweet tweet) {
		ErrorStatus errorStatus = new ErrorStatus();
		int tweetId = tweetDao.saveOrUpdate(tweet);
		tweet = tweetDao.getTweet(tweetId);
		User u = userDao.getUser(tweet.getUserId());
		if(u == null)
			errorStatus.addError(ErrorCode.USER_FETCH_ERROR);
		userTweetDao.saveUserTweets(u.getId(), tweetId);
		List<UserFollower> followers = userFollowerDao.getFollowers(u.getId());
		if(followers != null){
			for(UserFollower follower : followers)
			userTweetDao.saveUserTweets(follower.getUserId(), tweetId);
		}
		return errorStatus;
		
	}

	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}


	@Override
	public List<Tweet> getTweets(int userId) {
		return getTweets(userId, -1,-1);
	}

	@Override
	public List<Tweet> getTweets(int userId, int pageSize, int pageNo) {
		User u = userDao.getUser(userId);
		if(u != null)
			return userTweetDao.getUserTweets(userId, pageSize, pageNo);
		return null;
	}

}
