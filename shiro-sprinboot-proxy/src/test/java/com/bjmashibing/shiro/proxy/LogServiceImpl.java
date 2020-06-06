package com.bjmashibing.shiro.proxy;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-06 15:05
 */
public class LogServiceImpl implements LogService {

    @Override
    public void log() {
        System.out.println("记录日志");
    }
}
