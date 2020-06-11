package com.venkat.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.venkat.moviecatalogservice.models.Rating;
import com.venkat.moviecatalogservice.models.UserRatings;

@Service
public class UserRatingsInfo {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRatings")
	public UserRatings getUserRatings(@PathVariable("userId") String userId)
	{
	   return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRatings.class);
	}
	
	public UserRatings getFallbackUserRatings(@PathVariable("userId") String userId)
	{
	   UserRatings userRatings = new UserRatings();
	   userRatings.setUserRatings(Arrays.asList(new Rating("0", 0)));
	   return userRatings;
	}
}
