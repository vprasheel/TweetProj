package com.proj.twitter.messages;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FollowRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class FollowRequest implements Serializable {
	
	@XmlElement(name="userId")
	private int userId;
	
	@XmlElement(name="followUserId")
	private int followUserId;

	public int getUserId() {
		return userId;
	}

	public int getFollowUserId() {
		return followUserId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFollowUserId(int followUserId) {
		this.followUserId = followUserId;
	}

}
