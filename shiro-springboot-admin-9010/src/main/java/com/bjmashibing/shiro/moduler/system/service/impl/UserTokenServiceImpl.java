package com.bjmashibing.shiro.moduler.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjmashibing.shiro.framework.util.R;
import com.bjmashibing.shiro.moduler.system.entity.UserToken;
import com.bjmashibing.shiro.moduler.system.mapper.UserTokenMapper;
import com.bjmashibing.shiro.moduler.system.service.UserTokenService;
import com.bjmashibing.shiro.shiro.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;


	@Override
	public R createToken(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		UserToken tokenEntity = this.getById(userId);
		if(tokenEntity == null){
			tokenEntity = new UserToken();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			this.save(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			this.updateById(tokenEntity);
		}

		R r = R.ok().put("token", token).put("expire", EXPIRE);

		return r;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//修改token
		UserToken tokenEntity = new UserToken();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		this.updateById(tokenEntity);
	}
}
