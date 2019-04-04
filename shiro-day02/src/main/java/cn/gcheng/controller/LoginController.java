package cn.gcheng.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author gcheng.L
 * @create 2019-03-21 15:39
 */

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        String exMessage = "";
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            // 获取subject
            Subject subject = SecurityUtils.getSubject();
            // 创建表单获取用户名密码
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            try {
                // 登陆
                subject.login(usernamePasswordToken);
                return "redirect:index.do";
            } catch (UnknownAccountException uae) {
                // 帐号不存在
                exMessage = "帐号不存在";
                logger.debug("UnknownAccountException---->user:{},password:{}",username,password);
            }catch (IncorrectCredentialsException ie) {
                exMessage = "用户名或密码错误，错误信息：" + ie.getMessage();
                logger.debug("IncorrectCredentialsException---->user:{},password:{}",username,password);
            } catch (LockedAccountException le) {
                exMessage = "该账号已锁定，错误信息：" + le.getMessage();
                logger.debug("LockedAccountException---->user:{},password:{}",username,password);
            } catch (DisabledAccountException de) {
                exMessage = "该账号已禁用，错误信息：" + de.getMessage();
                logger.debug("DisabledAccountException---->user:{},password:{}",username,password);
            } catch (ExcessiveAttemptsException eae) {
                exMessage = "该账号登录失败次数过多，错误信息：" + eae.getMessage();
                logger.debug("ExcessiveAttemptsException---->user:{},password:{}",username,password);
            } catch (Exception e){
                exMessage = "未知错误，错误信息：" + e.getMessage();
                logger.debug("Exception---->user:{},password:{}",username,password);
            }

        }
        model.addAttribute("exMessage", exMessage);
        return "/login";
    }
}


