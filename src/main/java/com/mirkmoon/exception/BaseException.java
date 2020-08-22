package com.mirkmoon.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.mirkmoon.dto.Status;

/**
 * ClassName: BaseException.java
 * Description: 异常基类
 * Author: liqihuang
 *
 * @createTime 2020年08月19日 23:27
 * Version: 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Status status, Object data) {
        this(status);
        this.data = data;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Object data) {
        this(code, message);
        this.data = data;
    }


}