package com.proj.twitter.messages;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="UnFollowRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnFollowRequest implements Serializable{
	
	@XmlElement(name="userId")
	private int userId;
	
	@XmlElement(name="unfollowUserId")
	private int unfollowUserId;

	public int getUserId() {
		return userId;
	}

	public int getUnFollowUserId() {
		return unfollowUserId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUnFollowUserId(int unfollowUserId) {
		this.unfollowUserId = unfollowUserId;
	}

}
