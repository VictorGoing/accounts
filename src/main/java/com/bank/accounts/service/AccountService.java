package com.bank.accounts.service;

import com.bank.accounts.repository.AccountRepository;
import com.bank.accounts.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountService {


    private final AccountRepository accountRepository;

    public Account saveAccount(Account account){return accountRepository.save(account);}

    public List<Account> getAccountByCustomerId(Long customerId){
        return accountRepository.findAccountsByCustomerId(customerId);
    }
}
