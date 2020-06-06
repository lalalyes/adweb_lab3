package com.example.lab3.bean;

public class ResponseBean {
    // http 状态码
    protected int code;
    // 返回信息
    protected String msg;
    // 返回的数据
    protected Object data;

    public ResponseBean(){

    }
    public ResponseBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
