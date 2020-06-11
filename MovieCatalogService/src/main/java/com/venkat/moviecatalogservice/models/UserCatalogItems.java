package com.venkat.moviecatalogservice.models;

import java.util.List;

public class UserCatalogItems {
	
	private List<CatalogItem> userCatalogItems;

	public UserCatalogItems(List<CatalogItem> userCatalogItems) {
		this.userCatalogItems = userCatalogItems;
	}

	public List<CatalogItem> getUserCatalogItems() {
		return userCatalogItems;
	}

	public void setUserCatalogItems(List<CatalogItem> userCatalogItems) {
		this.userCatalogItems = userCatalogItems;
	}
	

}
