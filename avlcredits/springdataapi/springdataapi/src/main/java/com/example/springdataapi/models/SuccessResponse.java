package com.example.springdataapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse implements ResponseModel {

    @JsonIgnore
    private int statusCode;
    @JsonProperty("available")
    private boolean isAvailable;
    @JsonIgnore
    private String messageDescription;

    public SuccessResponse(boolean isAvailableInput) {
        this.statusCode = 200;
        this.isAvailable = isAvailableInput;

        if (isAvailable) {
            this.messageDescription = "Enough available funds.";
        } else {
            this.messageDescription = "Not enough available funds.";
        }
    }
}
