package com.learning.services.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.models.Account;
import com.learning.repositories.AccountRepository;
import com.learning.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account login(String username, String password) {
		Account account = accountRepository.findByUsername(username);
//		3 conditions
		if (account != null) {
			if(BCrypt.checkpw(password, account.getPassword()) && account.isStatus()) {
				return account;
			}
		}
		return null;
	}
	
	@Override
	public Account findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

}
