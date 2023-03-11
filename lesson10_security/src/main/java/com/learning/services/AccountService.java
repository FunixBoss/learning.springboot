package com.learning.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learning.models.Account;


public interface AccountService extends UserDetailsService {
	Iterable<Account> findAll();
	Account save(Account account);
	Account findByUsername(String username);
}
