package com.proj.twitter.messages;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TweetRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class TweetRequest implements Serializable{
	
	@XmlElement(name="userId")
	private int userId;
	
	@XmlElement(name="content")
	private String content;

	public int getUserId() {
		return userId;
	}

	public String getContent() {
		return content;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	

}
