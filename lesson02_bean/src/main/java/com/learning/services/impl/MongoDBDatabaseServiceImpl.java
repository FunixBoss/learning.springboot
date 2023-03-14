package com.learning.services.impl;

import org.springframework.stereotype.Service;

import com.learning.services.DatabaseService;

@Service("mongoDBDatabaseService")
public class MongoDBDatabaseServiceImpl implements DatabaseService {

	@Override
	public String findAll() {
		return "findAll - mongoDB";
	}

	@Override
	public String find(int id) {
		return "Find by id: " + id + " - mongoDB";
	}

}
