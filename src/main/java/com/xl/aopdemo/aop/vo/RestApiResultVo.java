package com.xl.aopdemo.aop.vo;

import lombok.Data;

public class RestApiResultVo<T> {

    private String code;

    private String message;

    private T content ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public RestApiResultVo() {
    }

    public RestApiResultVo(String code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public static <T> RestApiResultVo<T> ok (T content) {
        return new RestApiResultVo<>("0000","succ",content);
    }

    public static RestApiResultVo ok () {
        return new RestApiResultVo("0000","succ",null);
    }

    public static RestApiResultVo fail (String code, String message) {
        return new RestApiResultVo(code,message,null);
    }
}
