package com.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}
