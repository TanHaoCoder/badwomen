package badwomen.controller;

import badwomen.model.Employee;
import badwomen.service.EmployeeService;
import badwomen.util.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 4:01
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     *
     *
     * @description: 跳转到更改密码页面
     * @param null
     * @return:
     * @author: tanhao
     * @time: 2020/2/25 18:23
     */
    @RequestMapping("/emp/toUpdaDate/{username}")
    public String toEmpUpdate(@PathVariable("username")String username,
                              Model model){
        Employee employee = employeeService.byUsername(username);
        model.addAttribute("employee",employee);
        return "emp/update_data";
    }

    /**
     *
     *
     * @description: 提交密码并跳转到登录页
     * @param null
     * @return:
     * @author: tanhao
     * @time: 2020/2/25 18:36
     */
    @RequestMapping("/emp/updateData/{username}")
    public String emp_update(@PathVariable("username")String username,@RequestParam("password")String password){
        System.out.println(employeeService.byUsername(username));
        String pwd = Md5Hash.getInputPasswordCiph(password,employeeService.byUsername(username).getSalt());
        System.out.println(pwd);
        employeeService.updateEmployeeData(username,pwd);
        return "login";
    }
}
