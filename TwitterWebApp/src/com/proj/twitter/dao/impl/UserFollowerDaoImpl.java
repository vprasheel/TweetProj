package com.proj.twitter.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import com.proj.twitter.dao.UserFollowerDao;
import com.proj.twitter.model.beans.UserFollower;

@Repository("UserFollowerDao")
public class UserFollowerDaoImpl implements UserFollowerDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	 private EntityManager em;
	
	@Override
	public List<UserFollower> getFollowers(int userId) {
		String query = "from UserFollower uf where uf.followId = :userId ";
		
		return  em.createQuery(query)
				.setParameter("userId",userId)
				.getResultList();
	}

	@Override
	public void saveUserFollower(int userId, int followId) {
		UserFollower uf = new UserFollower();
		uf.setUserId(userId);
		uf.setFollowId(followId);
		
		em.persist(uf);
	}

}
