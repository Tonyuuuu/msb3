package com.bjmashibing.shiro.moduler.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjmashibing.shiro.moduler.system.entity.Captcha;
import com.bjmashibing.shiro.moduler.system.mapper.CaptchaMapper;
import com.bjmashibing.shiro.moduler.system.service.CaptchaService;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 验证码
 *
 * @author liuzp
 * @since 2.0.0 2018-02-10
 */
@Service("captchaService")
public class CaptchaServiceImpl extends ServiceImpl<CaptchaMapper, Captcha> implements CaptchaService {
    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new RuntimeException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        Captcha captchaEntity = new Captcha();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        this.save(captchaEntity);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        LambdaQueryWrapper<Captcha> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Captcha::getUuid, uuid);
        Captcha captchaEntity = this.getOne(wrapper);
        if(captchaEntity == null){
            return false;
        }

        //删除验证码
        this.removeById(uuid);

        if(captchaEntity.getCode().equalsIgnoreCase(code)){
            return true;
        }

        return false;
    }
}
