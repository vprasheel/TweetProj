package com.proj.twitter.util;

import java.util.Comparator;

import com.proj.twitter.messages.TweetMessage;

public class TweetComparator implements Comparator<TweetMessage>{

	@Override
	public int compare(TweetMessage t1, TweetMessage t2) {
		if(t1.getCreateTime() > t2.getCreateTime())
			return -1;
		else if(t1.getCreateTime() < t2.getCreateTime())
			return 1;
		else 
			return 0;
				
	}

	

}
