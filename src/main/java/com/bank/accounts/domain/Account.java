package com.bank.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID",unique = true)
    private Long id;

    @Column(name = "NRB")
    private String nrb;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "AVAILABLE_FUNDS")
    private BigDecimal availableFunds;

    public Account(String nrb, String currency, BigDecimal availableFunds){
        this.nrb = nrb;
        this.currency = currency;
        this.availableFunds = availableFunds;
    }
}
