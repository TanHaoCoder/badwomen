package badwomen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/24 3:13
 */
@Controller
public class LogoutAndUnauthorizedController {
    @RequestMapping("/logOut")
    public String logout(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:index";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未授权无法访问此页面";
    }
}
