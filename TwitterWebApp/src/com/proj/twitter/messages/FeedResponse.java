package com.proj.twitter.messages;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FeedResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedResponse implements Serializable{

	public Set<TweetMessage> getTweets() {
		return tweets;
	}

	public void setTweets(Set<TweetMessage> tweets) {
		this.tweets = tweets;
	}

	@XmlElement(name="tweets")
	private Set<TweetMessage> tweets;
	
}
