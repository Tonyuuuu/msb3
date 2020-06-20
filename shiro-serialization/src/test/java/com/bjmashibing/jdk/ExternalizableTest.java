package com.bjmashibing.jdk;

import com.bjmashibing.entity.User;
import com.bjmashibing.entity.User1;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-15 22:08
 */
public class ExternalizableTest {
    /**
     * 测试序列化
     * @throws Exception
     */
    @Test
    public void testSeri()throws Exception{
        //初始化对象
        User1 user = new User1();
        user.setId(1L);
        user.setUsername("序列化");
        //序列化对象到文件中
        File file = new File("result1.obj");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(user);
        oos.close();
    }
    /**
     * 测试反序列化
     * @throws Exception
     */
    @Test
    public void testDesSeri()throws Exception{
        File file = new File("result1.obj");
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User1 newUser = (User1) ois.readObject();
        System.out.println(newUser.toString());
    }


    /**
     * 测试static修饰的属性能否被序列化
     * @throws Exception
     */
    @Test
    public void testStaticSeri()throws Exception{
        //初始化对象
        User1 user = new User1();
        user.setId(1L);
        user.setUsername("序列化");
        System.out.println(user);
        //序列化对象到文件中
        File file = new File("result1.obj");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(user);
        oos.close();
        //反序列化
        User1.realName = "update";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User1 newUser = (User1)ois.readObject();
        System.out.println(newUser.realName);
    }
    /**
     * 测试static修饰的属性能否被序列化
     * @throws Exception
     */
    @Test
    public void testExtendsSeri()throws Exception{
        //初始化对象
        User1 user = new User1();
        user.setId(1L);
        user.setUsername("序列化");
        user.setSuperName("父亲");

        System.out.println(user);
        //序列化对象到文件中
        File file = new File("result.obj");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(user);
        oos.close();
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User1 newUser = (User1)ois.readObject();
        System.out.println(newUser.getSuperName());
    }
}
