package com.bank.accounts.repository;

import com.bank.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByCustomerId(Long customerId);
}
