package ru.rsreu.carservice.controller;

public class Url {
	
	private String url;
	private RedirectType redirectType;
	
	public Url(String url, RedirectType redirectType) {
		this.url = url;
		this.redirectType = redirectType;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public RedirectType getRedirectType() {
		return this.redirectType;
	}
}
