package com.devmf.chairSystem.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorInfo {
    private int statusCode;
    private String message;
    private String uriRequested;

}
