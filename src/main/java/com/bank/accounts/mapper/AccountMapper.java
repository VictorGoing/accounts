package com.bank.accounts.mapper;

import com.bank.accounts.domain.Account;
import com.bank.accounts.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountMapper {

    public AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getNrb(),
                account.getCurrency(),
                account.getAvailableFunds());

    }

    public Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getNrb(),
                accountDto.getCurrency(),
                accountDto.getAvailableFunds());
    }

}
