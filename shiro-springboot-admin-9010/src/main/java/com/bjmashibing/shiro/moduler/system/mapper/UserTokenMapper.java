package com.bjmashibing.shiro.moduler.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjmashibing.shiro.moduler.system.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 * 
 * @author liuzp
 * @email liuzp6@163.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {

    UserToken queryByToken(String token);
	
}
