package badwomen.mapper;

import badwomen.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 1:48
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 查询所有员工
     * @return 返回所有用户--管理员功能
     */
    List<Employee> findAll();

    /**
     * 通过用户名查询一个用户，登录时使用
     * @param username 用户名
     * @return 返回一个用户对象
     */
    Employee byUsername(String username);

    /**
     *查询员工列表时时使用--管理员功能
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

    /*@Insert("insert into b605.Employee (`username`,`password`,`salt`,`role`) values (#{username},#{password},#{salt},#{role})")
    void test(String username,String password,String salt,String role);*/
}
