package com.bank.accounts.controller;

import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.exception.NotFoundAccountException;
import com.bank.accounts.mapper.AccountMapper;
import com.bank.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping(value = "{customerId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long customerId) throws NotFoundAccountException {
        AccountDto accountDto = accountMapper.mapToAccountDto(accountService.getAccountById(customerId));
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping
    public ResponseEntity<Void> addAccount(@RequestBody AccountDto accountDto){
        accountService.saveAccount(accountMapper.mapToAccount(accountDto));
        return ResponseEntity.ok().build();
    }
}
