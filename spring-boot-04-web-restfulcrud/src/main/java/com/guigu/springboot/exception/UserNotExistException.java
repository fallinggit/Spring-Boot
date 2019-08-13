package com.guigu.springboot.exception;

//使异常可抛出，继承运行时异常
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
