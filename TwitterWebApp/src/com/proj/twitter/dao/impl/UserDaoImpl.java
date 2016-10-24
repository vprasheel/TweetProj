package com.proj.twitter.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Repository;
import com.proj.twitter.dao.UserDao;
import com.proj.twitter.model.beans.User;


/**
 * This class implements the user Dao interface that interacts with
 * the USER database table
 * @author prasheel
 *
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	 private EntityManager em;
	

	public UserDaoImpl(){
		System.out.println("UserDaoImpl initialized");
	}
	
	@Override
	public User getUser(int id) {
		String query = "from User u where u.id = :Id ";
		
		return (User)em.createQuery(query)
				.setParameter("Id",id)
				.getSingleResult();
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId() > 0){
			em.merge(user);
		}
		else{
			em.persist(user);
			em.flush();
		}
	}
	
}
