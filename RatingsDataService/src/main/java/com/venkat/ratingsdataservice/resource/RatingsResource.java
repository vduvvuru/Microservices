package com.venkat.ratingsdataservice.resource;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.ratingsdataservice.models.Rating;
import com.venkat.ratingsdataservice.models.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String userId)
	{
		return new UserRatings(Arrays.asList(new Rating("1234", 4), new Rating("5678", 3)));
	}

}
