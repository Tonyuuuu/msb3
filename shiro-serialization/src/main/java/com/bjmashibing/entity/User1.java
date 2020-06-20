package com.bjmashibing.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-16 20:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User1 extends UserSuper implements Externalizable {
    private static final long serialVersionUID = 2L;

    /**
     * 用户主键
     */
    private Long id;

    /**
     * 登录账户
     */
    private String username;

    public static String realName ="static";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(username);
        out.writeObject(realName);
        out.writeObject(super.getSuperName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Long) in.readObject();
        username = (String) in.readObject();
        realName = (String) in.readObject();
        String superName = (String) in.readObject();
        setSuperName(superName);

    }


}
