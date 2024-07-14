package com.example.springdataapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FailureResponse implements ResponseModel {

    @JsonProperty("errorCode")
    private int statusCode;
    @JsonProperty("errorDescription")
    private String messageDescription;

}
