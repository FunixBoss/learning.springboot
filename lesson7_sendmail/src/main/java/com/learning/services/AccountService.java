package com.learning.services;

import com.learning.models.Account;

public interface AccountService {
	
	Account save(Account account);
	
	Account login(String username, String password);
	
	Account findByEmail(String email);
}
