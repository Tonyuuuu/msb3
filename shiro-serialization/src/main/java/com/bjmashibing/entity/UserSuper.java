package com.bjmashibing.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-06-16 21:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserSuper {

    private String superName;

}
