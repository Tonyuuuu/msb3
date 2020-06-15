package com.bjmashibing.shiro.patterns.builder;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-13 17:36
 */
public class TestSubjectBuilder {
    public static void main(String[] args) {
        SecurityManager securityManager = new DefaultSecurityManager();
        Subject subject1 = new Subject.Builder(securityManager).authenticated(false).buildSubject();
        Subject subject2 = new Subject.Builder(securityManager).authenticated(true).buildSubject();
        System.out.println(subject1.isAuthenticated());
        System.out.println(subject2.isAuthenticated());

    }
}
