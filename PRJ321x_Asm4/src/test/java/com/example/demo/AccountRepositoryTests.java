package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AccountRepositoryTests {
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private AccountRepository repo;
    
    @Test
    public void testCreateUser() {
        Account acc = new Account();
        acc.setEmail("takeshi@gmail.com");
        acc.setPassword("12345");
        acc.setFirstName("Takeshi");
        acc.setLastName("Meomeo");
         
        Account savedAcc = repo.save(acc);
         
        Account existAcc = entityManager.find(Account.class, savedAcc.getId());
         
        assertThat(acc.getEmail()).isEqualTo(existAcc.getEmail());
         
    }
     
}
