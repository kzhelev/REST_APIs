package com.example.springdataapi.repositories;

import com.example.springdataapi.models.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepo extends JpaRepository<AccountInfo, String> {
    AccountInfo getByCustomerNo(String customerAccountNo);
}
