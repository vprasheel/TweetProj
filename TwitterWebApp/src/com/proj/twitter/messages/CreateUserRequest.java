package com.proj.twitter.messages;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CreateUserRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateUserRequest implements Serializable{

	@XmlElement(name="firstName")
	private String firstName;
	
	@XmlElement(name="lastName")
	private String lastName;
	
	@XmlElement(name="loginId")
	private String loginId;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
}
