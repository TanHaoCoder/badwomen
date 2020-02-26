package badwomen.controller;

import badwomen.model.Employee;
import badwomen.service.EmployeeService;
import badwomen.util.Md5Hash;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 2:39
 */
@Slf4j
@Controller
public class LoginAndRegisterController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(Employee employee, Model model){
        employee.setPassword(Md5Hash.getInputPasswordCiph(employee.getPassword(),employeeService.selectSaltByUsername(employee.getUsername())));
        log.error(employee.getPassword());
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(employee.getUsername(), employee.getPassword());
        /*
         * login()方法会调用 Realm类中执行认证逻辑的方法，并将这个参数传递给doGetAuthenticationInfo()方法
         * 执行登录方法
         * */
        try{

            subject.login(token);
            model.addAttribute("employee",employeeService.byUsername(token.getUsername()));
            return "emp/personal";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(Employee employee){
        String[] pwd = Md5Hash.encryptPassword(employee.getPassword());
        employee.setSalt(pwd[0]);
        employee.setPassword(pwd[1]);
        employeeService.addEmployee(employee);

        return "index";
    }
}
