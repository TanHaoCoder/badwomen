package badwomen.controller;

import badwomen.dto.PaginationDTO;
import badwomen.service.EmployeeService;
import badwomen.serviceimpl.EmployeeListServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/24 1:59
 */
@Slf4j
@Controller
public class AdminCotroller {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeListServiceImpl employeeListService;


    @RequestMapping("/admin/findAllEmployee")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "20")Integer size) {
        PaginationDTO employees = employeeListService.list(page, size);
        System.out.println(employees.toString());
        model.addAttribute("emps", employees);
        return "admin/select_all_employee";
    }



}
