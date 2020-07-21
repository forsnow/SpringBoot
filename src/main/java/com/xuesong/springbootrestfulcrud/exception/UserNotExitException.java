package com.xuesong.springbootrestfulcrud.exception;

/**
 * @author: Snow
 * @create: 2020-07-21 18:00
 **/
public class UserNotExitException extends RuntimeException{
    public UserNotExitException() {
        super("用户不存在");
    }
}
