package com.bank.accounts.controller;

import com.bank.accounts.controller.response.GetAccountsResponse;
import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.exception.NotFoundAccountException;
import com.bank.accounts.mapper.AccountMapper;
import com.bank.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping
    public ResponseEntity<GetAccountsResponse> getAccountById(@RequestParam Long customerId) throws NotFoundAccountException {
        AccountDto accountDto = accountMapper.mapToAccountDto(accountService.getAccountById(customerId));
        List<AccountDto> list = new ArrayList<>();
        list.add(accountDto);
        return ResponseEntity.ok(new GetAccountsResponse(list));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAccount(@RequestBody AccountDto accountDto){
        accountService.saveAccount(accountMapper.mapToAccount(accountDto));
        return ResponseEntity.ok().build();
    }
}
