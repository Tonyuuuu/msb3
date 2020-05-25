package com.bjmashibing.shiro.moduler.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjmashibing.shiro.moduler.system.entity.Captcha;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author liuzp
 * @since 3.1.0 2018-02-10
 */
@Mapper
public interface CaptchaMapper extends BaseMapper<Captcha> {

}
