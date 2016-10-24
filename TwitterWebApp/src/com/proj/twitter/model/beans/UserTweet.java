package com.proj.twitter.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TWEETS")
public class UserTweet implements Serializable{
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Id
	@Column(name="TWEET_ID")
	private int tweetId;

	public int getUserId() {
		return userId;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

}
