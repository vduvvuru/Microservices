package com.venkat.configuration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.configuration.DbConfiguration;

@RestController
public class ConfigurationController {
	
	@Value("${my.greetings : default value if no property available in properties file}")
	private String greetingMessage;
	
	@Value("Hello I am static message")
	private String staticValue;
	
	@Value("${my.list.values}")
	private List<String> myList;
	
	@Value("#{${dbValues}}")
	private Map<String, String> dbValues;
	
	@Autowired
	DbConfiguration dbConfiguration;
	
	@GetMapping("/greeting")
	public String greetings()
	{
		return greetingMessage + staticValue + myList + dbConfiguration.getConnection() + dbConfiguration.getHost() + dbConfiguration.getPort();
	}

}
