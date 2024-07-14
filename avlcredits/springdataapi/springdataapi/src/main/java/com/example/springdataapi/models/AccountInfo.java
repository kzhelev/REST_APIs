package com.example.springdataapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_balance_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {

    @Id
    @Column(name = "customer_no", length = 20)
    private String customerNo;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "currency")
    private String currency;
}
