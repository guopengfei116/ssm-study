package cn.me.controller;

import cn.me.model.Account;
import cn.me.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // 登陆页面
    @RequestMapping("/toLogin.do")
    public String toLogin() {
        return "account/login";
    }

    // 登陆接口
    @RequestMapping("/login.do")
    public String login(String username, String password, HttpSession httpSession) {

        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            httpSession.setAttribute("user", username);
        }else {
            return "account/login";
        }

        return "redirect:/goods/list.do";
    }

    @RequestMapping("/list.do")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Account> list = accountService.findAllAccount();
        System.out.println(list);
        mv.addObject("list", list);
        mv.setViewName("account/list");
        return mv;
    }
}
