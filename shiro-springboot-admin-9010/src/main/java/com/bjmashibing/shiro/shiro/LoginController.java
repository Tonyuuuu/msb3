package com.bjmashibing.shiro.shiro;

import com.bjmashibing.shiro.framework.util.R;
import com.bjmashibing.shiro.moduler.system.entity.LoginForm;
import com.bjmashibing.shiro.moduler.system.entity.User;
import com.bjmashibing.shiro.moduler.system.service.CaptchaService;
import com.bjmashibing.shiro.moduler.system.service.UserService;
import com.bjmashibing.shiro.moduler.system.service.UserTokenService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * <p></p>
 *
 * @author sunzhiqiang23
 * @date 2020-05-23 13:30
 */
@RestController
public class LoginController {
    @Autowired
    private Producer producer;
    @Autowired
    private UserTokenService sysUserTokenService;
    @Autowired
    private UserService userService;
    @Autowired
    private CaptchaService captchaService;
    /**
     * 登录
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody LoginForm form)throws IOException {
        boolean captcha = captchaService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return R.error("验证码不正确");
        }

        //用户信息
        User user = userService.queryByUserName(form.getUsername());

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Md5Hash(form.getPassword(), user.getSecretkey()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if(user.getLocked() == 1){
            return R.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        R r = sysUserTokenService.createToken(user.getId());
        return r;
    }


    /**
     * 退出
     */
    @PostMapping("/sys/logout")
    public R logout() {
        sysUserTokenService.logout(ShiroUtils.getUserId());
        return R.ok();
    }

    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = captchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
}
