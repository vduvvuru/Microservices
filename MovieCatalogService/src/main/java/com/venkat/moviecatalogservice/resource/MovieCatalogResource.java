package com.venkat.moviecatalogservice.resource;

import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.venkat.moviecatalogservice.models.UserCatalogItems;
import com.venkat.moviecatalogservice.models.UserRatings;
import com.venkat.moviecatalogservice.services.MovieInfo;
import com.venkat.moviecatalogservice.services.UserRatingsInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingsInfo userRatingsInfo;
	
	
	@RequestMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON)
	public UserCatalogItems getCatalog(@PathVariable("userId") String userId)
	{
		UserRatings userRatings = userRatingsInfo.getUserRatings(userId);
		
		return new UserCatalogItems(userRatings.getUserRatings().stream().map(rating-> movieInfo.getCatalogItem(rating)).collect(Collectors.toList()));
	}

	   
}
