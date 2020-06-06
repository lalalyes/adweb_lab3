package com.example.lab3.response;

import com.example.lab3.bean.ResponseBean;

public class ErrorResponse extends ResponseBean {
    public ErrorResponse(String msg, Object data) {
        this.code = 400;
        this.msg = msg;
        this.data=data;
    }
}
