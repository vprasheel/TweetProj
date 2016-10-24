package com.proj.twitter.dao;

import java.util.List;

import com.proj.twitter.model.beans.UserFollower;

public interface UserFollowerDao {
	
	public List<UserFollower> getFollowers(int userId);
	
	public void saveUserFollower(int userId, int followId);
	
}
