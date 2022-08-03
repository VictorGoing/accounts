package com.bank.accounts.controller;

import com.bank.accounts.controller.response.GetAccountsResponse;
import com.bank.accounts.dto.AccountDto;
import com.bank.accounts.exception.NotFoundAccountException;
import com.bank.accounts.mapper.AccountMapper;
import com.bank.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RefreshScope
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetAccounts;

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping
    public ResponseEntity<GetAccountsResponse> getAccountById(@RequestParam("customerId") Long customerId){
        log.info("Get accounts for customerId: {}", customerId);
        if(!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        List<AccountDto> list = accountMapper.mapToAccountDtoList(accountService.getAccountById(customerId));
        return ResponseEntity.ok(new GetAccountsResponse(list));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addAccount(@RequestBody AccountDto accountDto){
        accountService.saveAccount(accountMapper.mapToAccount(accountDto));
        return ResponseEntity.ok().build();
    }
}
