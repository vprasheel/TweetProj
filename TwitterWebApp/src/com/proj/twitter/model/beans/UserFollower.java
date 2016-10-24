package com.proj.twitter.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_FOLLOWER")
public class UserFollower implements Serializable{
	
	@Id
	@Column(name="USER_ID")
	private int userId;
	
	@Id
	@Column(name="FOLLOW_ID")
	private int followId;

	public int getUserId() {
		return userId;
	}

	public int getFollowId() {
		return followId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}
	
	
	

}
