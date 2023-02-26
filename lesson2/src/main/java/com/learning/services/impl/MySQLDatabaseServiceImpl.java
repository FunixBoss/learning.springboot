package com.learning.services.impl;

import org.springframework.stereotype.Service;

import com.learning.services.DatabaseService;

@Service("mySQLDatabaseService")
public class MySQLDatabaseServiceImpl implements DatabaseService {

	@Override
	public String findAll() {
		return "findAll - MySQL";
	}

	@Override
	public String find(int id) {
		return "Find by id: " + id + " - MySQL";
	}

}
