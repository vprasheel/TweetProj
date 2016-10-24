package com.proj.twitter.model.beans;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TWITTER_USER")
public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private Timestamp createdTimestamp;
	private String loginId;
	//private Set<User> followers;
	//private Set<Tweet> tweets;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public int getId() {
		return id;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	
	@Column(name="CREATE_DATE")
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}
	
	@Column(name="LOGIN_ID")
	public String getLoginId() {
		return loginId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}
