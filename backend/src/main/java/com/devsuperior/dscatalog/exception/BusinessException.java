package com.devsuperior.dscatalog.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

    private Integer status;

    public BusinessException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public BusinessException(String arg0) {
        super(arg0);
        this.status = HttpStatus.BAD_REQUEST.value();
    }

    public BusinessException(String arg0, Integer status) {
        super(arg0);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
