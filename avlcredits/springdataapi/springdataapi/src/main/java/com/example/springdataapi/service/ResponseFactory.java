package com.example.springdataapi.service;

import com.example.springdataapi.models.FailureResponse;
import com.example.springdataapi.models.ResponseModel;
import com.example.springdataapi.models.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseFactory {

    public ResponseEntity<ResponseModel> createResponse(boolean customerAccNoIsCorrect, boolean ccyIsIdentical, boolean hasEnoughFunds) {

        if (!customerAccNoIsCorrect) {
            FailureResponse failureResponse = new FailureResponse(512, "No customer with that number!");
            return ResponseEntity.status(512).body(failureResponse);
        } else if (!ccyIsIdentical) {
            FailureResponse failureResponse = new FailureResponse(513, "Account currency doesn’t match to the requested one!");
            return ResponseEntity.status(513).body(failureResponse);
        } else if (hasEnoughFunds) {
            SuccessResponse successResponse = new SuccessResponse(true);
            return ResponseEntity.ok(successResponse);
        } else {
            SuccessResponse successResponse = new SuccessResponse(false);
            return ResponseEntity.ok(successResponse);
        }
    }
}
