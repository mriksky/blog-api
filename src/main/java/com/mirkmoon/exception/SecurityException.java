package com.mirkmoon.exception;

import com.mirkmoon.dto.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: SecurityException.java
 * Description: 全局异常
 * Author: liqihuang
 * @createTime 2020年08月27日 22:06
 * Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = true)
//@EqualsAndHashCode注解参考https://www.jianshu.com/p/16571aad10a2
public class SecurityException extends BaseException {

    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Status status, Object data) {
        super(status, data);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
