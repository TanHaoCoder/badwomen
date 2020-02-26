package badwomen.config;

import badwomen.model.Employee;
import badwomen.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/24 2:03
 */
public class EmployeeRealm extends AuthorizingRealm {

    @Autowired
    EmployeeService employeeService;

    /**
     *
     *
     * @description: 授权
     * @param null
     * @return:
     * @author: tanhao
     * @time: 2020/2/24 2:04
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        Employee currenEmployee = (Employee) subject.getPrincipal();
        //设置权限
        info.addStringPermission(currenEmployee.getRole());
        return info;
    }

    /**
     *
     *
     * @description: 认证
     * @param null
     * @return:
     * @author: tanhao
     * @time: 2020/2/24 2:04
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前的用户
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //连接数据库
        Employee employee = employeeService.byUsername(usernamePasswordToken.getUsername());
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        if (employee == null){
            return null;
        }
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginEmployee",employee);
        /*
         *
         * */
        return new SimpleAuthenticationInfo(employee,employee.getPassword(),"");
        //return new SimpleAuthenticationInfo("","","");
    }
}
