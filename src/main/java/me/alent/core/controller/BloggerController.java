package me.alent.core.controller;

import me.alent.core.po.Blogger;
import me.alent.core.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alent on 2017/7/24.
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @Resource
    private BloggerService bloggerService;

    @RequestMapping("/login")
    public String login(Blogger blogger, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject(); //获取当前登陆的主体
        String salt = "ssmBlog";
        String newPassword = new Md5Hash(blogger.getPassword(), salt).toString();//将密码使用md5加密
        //将用户信息封装到token中
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), newPassword);
        try {
            subject.login(token); //会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
            return "redirect:/admin/main.jsp";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            request.setAttribute("blogger", blogger);
            request.setAttribute("errorInfo", "用户名或密码错误");
            return "login";
        }

    }
}
