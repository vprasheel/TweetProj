package com.proj.twitter.messages;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TweetMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class TweetMessage implements Serializable{
	
	@XmlElement(name="userId")
	private int userId;
	
	@XmlElement(name="createTime")
	private long createTime;
	
	@XmlElement(name="content")
	private String content;
	
	@XmlElement(name="id")
	private long tweetId;
	
	public int getUserId() {
		return userId;
	}
	public long getCreateTime() {
		return createTime;
	}
	public String getContent() {
		return content;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getTweetId() {
		return tweetId;
	}
	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
	
	

}
