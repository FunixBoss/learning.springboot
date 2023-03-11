package com.learning.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.learning.models.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

	@Query("from Account where username = :username") 
	Account findByUsername(@Param("username") String username);
	
}
