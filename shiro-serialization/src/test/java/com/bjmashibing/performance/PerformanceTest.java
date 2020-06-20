package com.bjmashibing.performance;

import com.bjmashibing.entity.User;
import com.bjmashibing.entity.UserSuper;
import com.bjmashibing.util.KryoUtil;
import org.junit.jupiter.api.Test;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-17 21:08
 */
public class PerformanceTest {

    @Test
    public void testKryo() {
        UserSuper user = new UserSuper();
        user.setSuperName("测试");

        byte[] bytes = KryoUtil.writeToByteArray(user);
        UserSuper user1 = KryoUtil.readObjectFromByteArray(bytes, UserSuper.class);
        System.out.println(user1);

    }

}
