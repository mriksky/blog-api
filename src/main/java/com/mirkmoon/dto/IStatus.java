package com.mirkmoon.dto;

/**
 * InterfaceName: IStatus
 * Description: 返回信息的枚举类
 * Author: liqihuang
 * Date: 2020/8/19 22:52
 * Version: 1.0
 **/
public interface IStatus {
    /**
     * @description 状态码
     * @author liqihuang
     * @updateTime 2020/8/19 23:00
     * @throws
     * @return
     */
    Integer getCode();
    /**
     * @description 返回信息
     * @author liqihuang
     * @updateTime 2020/8/19 22:59
     * @throws
     * @return
     **/
    String getMessage();

    
}
