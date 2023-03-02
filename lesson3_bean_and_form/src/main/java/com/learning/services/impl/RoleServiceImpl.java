package com.learning.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.models.Language;
import com.learning.models.Role;
import com.learning.services.LanguageService;
import com.learning.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Override
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<>();
		roles.add(new Role("r1", "Role1"));
		roles.add(new Role("r2", "Role2"));
		roles.add(new Role("r3", "Role3"));
		roles.add(new Role("r4", "Role4"));

		return roles;
	}

}
