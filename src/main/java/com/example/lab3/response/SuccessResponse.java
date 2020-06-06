package com.example.lab3.response;

import com.example.lab3.bean.ResponseBean;

public class SuccessResponse extends ResponseBean {
    public SuccessResponse(String msg, Object data) {
        this.code = 200;
        this.msg = msg;
        this.data=data;
    }
}
