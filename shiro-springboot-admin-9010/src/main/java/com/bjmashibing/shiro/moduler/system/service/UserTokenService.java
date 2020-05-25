package com.bjmashibing.shiro.moduler.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjmashibing.shiro.framework.util.R;
import com.bjmashibing.shiro.moduler.system.entity.UserToken;

/**
 * 用户Token
 * 
 * @author liuzp

 * @date 2017-03-23 15:22:07
 */
public interface UserTokenService extends IService<UserToken> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
