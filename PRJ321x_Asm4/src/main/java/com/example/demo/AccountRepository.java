package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
	// select top 1 of query result
	@Query("SELECT u FROM Account u WHERE u.email = ?1")
    public Account findByEmail(String email);
}
