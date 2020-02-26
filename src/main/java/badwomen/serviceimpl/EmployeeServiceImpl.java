package badwomen.serviceimpl;

import badwomen.mapper.EmployeeMapper;
import badwomen.model.Employee;
import badwomen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 1:49
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll(){
        List<Employee> employees = employeeMapper.findAll();
        return employees;
    }

    @Override
    public Employee byUsername(String username) {
        Employee employee = employeeMapper.byUsername(username);
        return employee;
    }

    @Override
    public List<Employee> listByUsername() {
        List<Employee> employee = employeeMapper.listByUsername();
        return employee;
    }

    @Override
    public String selectSaltByUsername(String username) {
        String salt = employeeMapper.selectSaltByUsername(username);
        return salt;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void updateEmployeeData(String username, String password) {
        employeeMapper.updateEmployeeData(username, password);
    }

/*    @Override
    public void test(String username, String password, String salt, String role) {
        employeeMapper.test(username, password, salt, role);
    }*/

}
