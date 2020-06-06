package com.bjmashibing.shiro.framework.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-01 21:15
 */
class JwtUtilTest {

    @Test
    void verify() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1OTE0NDcyOTU4NTMiLCJleHAiOjE1OTE0NDc1OTUsImFjY291bnQiOiJzeXN0ZW0ifQ._y17zAMGtwGNDTmLNMmaEEGP99zMvognQqwla87174s";
        String account = JwtUtil.getClaim(token, "account");
        boolean system = JwtUtil.verify(token);
        System.out.println(system);

    }

    @Test
    void getClaim() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1OTE0NDcyOTU4NTMiLCJleHAiOjE1OTE0NDc1OTUsImFjY291bnQiOiJzeXN0ZW0ifQ._y17zAMGtwGNDTmLNMmaEEGP99zMvognQqwla87174s";
        String claim = "account";
        String account = JwtUtil.getClaim(token, claim);
        System.out.println(account);
    }

    @Test
    void sign() {
        String account = "system";
        String sign = JwtUtil.sign(account);
        System.out.println(sign);

    }
}