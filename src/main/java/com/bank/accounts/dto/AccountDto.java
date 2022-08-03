package com.bank.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private Long customerId;
    private String nrb;
    private String currency;
    private BigDecimal availableFunds;
}
