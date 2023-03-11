package com.learning.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.models.Role;
import com.learning.repositories.RoleRepository;
import com.learning.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

}
