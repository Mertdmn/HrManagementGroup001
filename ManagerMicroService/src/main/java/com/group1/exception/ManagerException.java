package com.group1.exception;

import lombok.Getter;



@Getter
public class ManagerException extends RuntimeException{

    private final ErrorType errorType;

    public ManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    public ManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
