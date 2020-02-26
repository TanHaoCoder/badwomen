package badwomen.service;

import badwomen.model.Employee;

import java.util.List;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 1:53
 */
public interface EmployeeService {
    /**
     *
     *
     * @description:
     * @param offset 页数
     * @param size 大小
     * @return:
     * @author: tanhao
     * @time: 2020/2/26 19:09
     */
    List<Employee> findAll();

    /**
     * 通过用户名查询一个用户，登录时使用
     * @param username 用户名
     * @return 返回一个用户对象
     */
    Employee byUsername(String username);

    /**
     * 查询员工列表时时使用--管理员功能
     * @param
     * @return 返回一个用户对象
     */
    List<Employee> listByUsername();

    /**
     * 通过用户名查询对应的盐值，登陆时使用。
     * @param username
     * @return 盐值
     */
    String selectSaltByUsername(String username);

    /**
     * 注册一个员工 管理员功能
     * @param employee
     */
    void addEmployee(Employee employee);

    /**
     *
     *
     * @description:更改员工资料--员工功能
     * @param username
     * @param password
     * @return: NULL
     * @author: tanhao
     * @time: 2020/2/26 4:12
     */
    void updateEmployeeData(String username,String password);

/*    void test(String username,String password,String salt,String role);*/
}
