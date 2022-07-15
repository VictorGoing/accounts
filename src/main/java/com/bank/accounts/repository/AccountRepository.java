package com.bank.accounts.repository;

import com.bank.accounts.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}
