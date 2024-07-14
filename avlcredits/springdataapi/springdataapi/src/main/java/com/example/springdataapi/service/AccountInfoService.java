package com.example.springdataapi.service;


import com.example.springdataapi.models.AccountInfo;
import com.example.springdataapi.repositories.AccountInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {

    private AccountInfoRepo accountsInfoRepo;

    @Autowired
    public AccountInfoService(AccountInfoRepo accountsInfoRepo) {
        this.accountsInfoRepo = accountsInfoRepo;
    }

    public AccountInfo getAccountInfoByCustAccNo(String custAccNo) {

        return accountsInfoRepo.getByCustomerNo(custAccNo);
    }
}
