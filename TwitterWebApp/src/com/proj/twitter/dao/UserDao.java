package com.proj.twitter.dao;

import com.proj.twitter.model.beans.User;

/**
 * interface for the User DAO
 * @author prasheel
 *
 */

public interface UserDao {
	
	public User getUser(int id);
	
	public void saveOrUpdate(User user);
	

}
