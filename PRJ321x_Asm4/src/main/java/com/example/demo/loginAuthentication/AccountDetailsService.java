package com.example.demo.loginAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Account;
import com.example.demo.AccountRepository;

public class AccountDetailsService implements UserDetailsService {
	
	@Autowired
    private AccountRepository accRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account acc = accRepo.findByEmail(username);
		if (acc == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        return new AccountDetails(acc);
	}

}
