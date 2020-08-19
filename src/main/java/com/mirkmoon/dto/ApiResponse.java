package com.mirkmoon.dto;

import com.mirkmoon.exception.BaseException;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ApiResponse
 * @Description:通用的 API 接口封装
 * @Author: liqihuang
 * @Date: 2020/8/19 19:00
 * @Version: v1.0
 **/
@Data
public class ApiResponse implements Serializable {

    //状态码
    private Integer code;
    //返回信息
    private String message;
    //返回的数据
    private Object data;

    //无参数函数
    public ApiResponse() {
    }

    /**
     * 全参构造函数
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     */
    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造一个自定义的API返回
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     * @return ApiResponse
     */
    public static ApiResponse of(Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }

    /**
     * @param
     * @return ApiResponse
     * @throws
     * @description 构造一个成功且不带数据的API返回
     * @updateTime 2020/8/19 23:03
     **/
    public static ApiResponse ofSuccess() {
        return ofSuccess();
    }

    /**
     * @param
     * @return ApiResponse
     * @throws
     * @description 构造一个成功带数据的API返回
     * @updateTime 2020/8/19 23:04
     **/
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(Status.SUCCESS,data);
    }

    /**
     * @param
     * @return
     * @throws
     * @description 构造一个有状态的API返回
     * @updateTime 2020/8/19 23:15
     **/
    public static ApiResponse ofStatus(String message) {
        return of(Status.SUCCESS.getCode(), message, null);
    }

    /**
     * @param
     * @return code 状态码  message状态信息 data数据
     * @throws
     * @description 构造一个有状态且带数据的API返回
     * @updateTime 2020/8/19 23:26
     **/
    public static ApiResponse ofStatus(IStatus status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }
    /**
     * @description 构造一个异常的API返回
     * @param 
     * @updateTime 2020/8/19 23:32
     * @throws 
     * @return 
     **/
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return of(t.getCode(), t.getMessage(), t.getData());
    }
}
