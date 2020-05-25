
package com.bjmashibing.shiro.moduler.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bjmashibing.shiro.moduler.system.entity.Captcha;

import java.awt.image.BufferedImage;

/**
 * 验证码
 *
 * @author liuzp
 * @since 2.0.0 2018-02-10
 */
public interface CaptchaService extends IService<Captcha> {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}
