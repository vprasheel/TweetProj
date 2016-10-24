package com.proj.twitter.model.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TWEET")
public class Tweet {

	private int tweetId;
	private int userId;
	private Timestamp createTime;
	private String content;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public int getTweetId() {
		return tweetId;
	}
	
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	
	@Column(name="CREATE_DATE")
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setCreateTime(Timestamp timeStamp) {
		this.createTime = timeStamp;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
