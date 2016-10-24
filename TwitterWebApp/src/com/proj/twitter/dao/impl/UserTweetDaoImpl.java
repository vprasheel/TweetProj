package com.proj.twitter.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.proj.twitter.dao.UserTweetDao;
import com.proj.twitter.model.beans.Tweet;
import com.proj.twitter.model.beans.UserTweet;

@Repository("UserTweetDao")
public class UserTweetDaoImpl implements UserTweetDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	 private EntityManager em;
	
	@Override
	public List<Tweet> getUserTweets(int userId, int pageSize, int pageNo) {
		//String query = "from UserTweet ut where ut.userId = :userId order by ut.tweetId desc";
		String query1 = "select t from Tweet t, UserTweet ut where t.id= ut.tweetId and ut.userId = :userId order by ut.tweetId desc";
		TypedQuery<Tweet> query = em.createQuery(query1, Tweet.class);
		
		if(pageSize <=0){
			return  query
					.setParameter("userId",userId)
					.getResultList();
		}
		else{
			return  query
				.setParameter("userId",userId)
				.setMaxResults(pageSize)
				.setFirstResult(pageSize * pageNo)
				.getResultList();
		}
				
	}

	@Override
	public void saveUserTweets(int userId, int tweetId) {
		UserTweet ut = new UserTweet();
		ut.setUserId(userId);
		ut.setTweetId(tweetId);
		
		em.persist(ut);

	}

}
