package com.group1.exception;

import lombok.Getter;



@Getter
public class PersonelManagerException extends RuntimeException{

    private final ErrorType errorType;

    public PersonelManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    public PersonelManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
