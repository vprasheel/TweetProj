package com.proj.twitter.endpoint;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.proj.twitter.messages.CreateUserRequest;
import com.proj.twitter.messages.FeedResponse;
import com.proj.twitter.messages.FollowRequest;
import com.proj.twitter.messages.TweetMessage;
import com.proj.twitter.messages.TweetRequest;
import com.proj.twitter.messages.UnFollowRequest;
import com.proj.twitter.model.beans.Tweet;
import com.proj.twitter.model.beans.User;
import com.proj.twitter.service.TwitterService;
import com.proj.twitter.util.TweetComparator;

@Service("TwitterEndpoint")
public class TwitterEndpoint {
	
	@Autowired
	@Qualifier("TwitterService")
	private TwitterService twitterService;
	
	@POST
	@Path("/tweet")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response tweet(TweetRequest request){
		
		Tweet tweet = new Tweet();
		tweet.setUserId(request.getUserId());
		tweet.setContent(request.getContent());
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		tweet.setCreateTime(ts);
		
		twitterService.tweet(tweet);
		
		return Response.status(201).build();
		
	}
	
	@GET
	@Path("/feed/{userId}")
	@Produces({ "application/json" })
	public Response feed(@PathParam("userId") int userId, @Context HttpServletRequest request){
		
		
		int pageSize =  -1;
		int pageNo = -1;
		
		try{
			pageSize = ServletRequestUtils.getIntParameter(request, "pSize");
			pageNo = ServletRequestUtils.getIntParameter(request, "pNo");
		}catch(Exception e){
			
		}
		
		List<Tweet> tweets =  twitterService.getTweets(userId, pageSize, pageNo);
		if(tweets == null)
			return Response.status(404).build();
		
		Set<TweetMessage> tMessages = new TreeSet<TweetMessage>(new TweetComparator());
		for(Tweet t: tweets){
			TweetMessage tMsg = new TweetMessage();
			tMsg.setCreateTime(t.getCreateTime().getTime());
			tMsg.setContent(t.getContent());
			tMsg.setUserId(t.getUserId());
			tMsg.setTweetId(t.getTweetId());
			tMessages.add(tMsg);
		}
		
		FeedResponse feedResponse = new FeedResponse();
		feedResponse.setTweets(tMessages);
		
		return Response.status(200).entity(feedResponse).build();
		
	}
	
	@POST
	@Path("/user")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createUser(CreateUserRequest request){
		
		User user = new User();
		user.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setLoginId(request.getLoginId());
		
		twitterService.createUser(user);
		
		return Response.status(201).build();
	}
	
	@POST
	@Path("/follow")
	@Consumes({ "application/json" })
	public Response followUser(FollowRequest request){
		
		twitterService.followUser(request.getUserId(), request.getFollowUserId());
		
		return Response.status(200).build();
		
	}
	
}
