package com.learning.paypal;

public class PaypalConfig {
	private String authToken;
	private String postUrl;
	private String business;
	private String returnurl;

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getReturnurl() {
		return returnurl;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	@Override
	public String toString() {
		return "PaypalConfig [authToken=" + authToken + ", postUrl=" + postUrl + ", business=" + business
				+ ", returnurl=" + returnurl + "]";
	}

	
}
