package com.proj.twitter.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.proj.twitter.dao.TweetDao;
import com.proj.twitter.model.beans.Tweet;

/**
 * Implementation Class for the Tweet DAO interface which implements 
 * the operations to fetch the Tweet data from the DB.
 * @author prasheel
 *
 */
@Repository("TweetDao")
public class TweetDaoImpl implements TweetDao{
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	 private EntityManager em;
	
	@Override
	public Tweet getTweet(int tweetId) {
		String query = "from Tweet t where t.tweetId = :tweetId ";
		
		return (Tweet)em.createQuery(query)
				.setParameter("tweetId",tweetId)
				.getSingleResult();
	}

	@Override
	public List<Tweet> getTweets(int userId) {
		String query = "from Tweet t where t.userId = :userId ";
		
		return em.createQuery(query)
				.setParameter("userId",userId)
				.getResultList();
		
	}

	@Override
	public int saveOrUpdate(Tweet tweet) {
		if(tweet.getTweetId() > 0){
			em.merge(tweet);
		}
		else{
			em.persist(tweet);
			em.flush();
		}
		return tweet.getTweetId();
	}

	@Override
	public void delete(Tweet tweet) {
		em.remove(tweet);
	}
	
	public List<Tweet> getUserTweets(long userId){
		
		return em.createNativeQuery("select tweet_id as id from user_tweets where user_id :id",Tweet.class)
			.setParameter("id",userId).getResultList();
	}

}
