package com.learning.models;

public class Address {
	private String street;
	private String ward;

	public Address() {
		
	}
	public Address(String street, String ward) {
		super();
		this.street = street;
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", ward=" + ward + "]";
	}

}
