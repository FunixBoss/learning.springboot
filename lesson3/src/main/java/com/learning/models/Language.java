package com.learning.models;

public class Language {
	private String id;
	private String name;

	public Language() {
		super();
	}

	public Language(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	}
}
