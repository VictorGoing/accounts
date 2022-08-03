package com.bank.accounts.service;

import com.bank.accounts.domain.Account;
import com.bank.accounts.exception.NotFoundAccountException;
import com.bank.accounts.repository.AccountRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountService {


    private final AccountRepository accountRepository;

    public Account saveAccount(Account account){return accountRepository.save(account);}

    public List<Account> getAccountById(Long customerId){
        return accountRepository.findAccountsByCustomerId(customerId);
    }
}
