package com.bank.accounts.mapper;

import com.bank.accounts.domain.Account;
import com.bank.accounts.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountMapper {

    public AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getCustomerId(),
                account.getNrb(),
                account.getCurrency(),
                account.getAvailableFunds());

    }

    public Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getCustomerId(),
                accountDto.getNrb(),
                accountDto.getCurrency(),
                accountDto.getAvailableFunds());
    }

    public List<AccountDto> mapToAccountDtoList(List<Account> accountList) {
        return accountList.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }

}
