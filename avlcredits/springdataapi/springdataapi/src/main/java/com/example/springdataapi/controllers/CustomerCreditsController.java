package com.example.springdataapi.controllers;

import com.example.springdataapi.models.AccountInfo;
import com.example.springdataapi.models.ResponseModel;
import com.example.springdataapi.models.dto.RequestDTO;
import com.example.springdataapi.service.AccountInfoService;
import com.example.springdataapi.service.ResponseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("customer-info")
public class CustomerCreditsController {

    private AccountInfoService accountInfoService;
    private ResponseFactory responseFactory;
    private static final Logger logger = LoggerFactory.getLogger(CustomerCreditsController.class);

    @Autowired
    public CustomerCreditsController(AccountInfoService accountInfoService, ResponseFactory responseFactory) {
        this.accountInfoService = accountInfoService;
        this.responseFactory = responseFactory;
    }

    @PostMapping("/credits-available")
    public @ResponseBody ResponseEntity<ResponseModel> checkAccountBalance(@RequestBody RequestDTO request){

        logger.debug("- - - - - - - - - - - - - - - - - - - - - -");
        logger.debug("New request for customer with number: " + request.getCustomerNo());

        String customerNo = request.getCustomerNo();
        String ccy = request.getCurrency();
        Double amount = request.getAmount();

        AccountInfo account = accountInfoService.getAccountInfoByCustAccNo(customerNo);

        boolean custAccNoIsCorrect = account != null;

        boolean ccyIsIdentical = false;

        boolean hasEnoughFunds = false;

        if (account != null) {

            ccyIsIdentical = ccy.equalsIgnoreCase(account.getCurrency());
            hasEnoughFunds = amount <= account.getBalance();
        }

        logger.debug("Creating response....");

        ResponseEntity<ResponseModel> response = responseFactory.createResponse(custAccNoIsCorrect,ccyIsIdentical,hasEnoughFunds);

        logger.debug("Response status code: " + response.getBody().getStatusCode());
        logger.debug("More information: " + response.getBody().getMessageDescription());
        logger.debug("Sending response...");

        return response;
    }
}
