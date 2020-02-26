package badwomen.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/24 2:02
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        //添加内置过滤器
        Map<String, String> fileterMap = new LinkedHashMap<>();
        fileterMap.put("/admin/*","perms[role:admin]");
        fileterMap.put("/emp/*","user");
        bean.setFilterChainDefinitionMap(fileterMap);
        //进不去跳转到登录页，设置登录页
        bean.setLoginUrl("/toLogin");
        //未授权用户的跳转页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("employeeRealm") EmployeeRealm employeeRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(employeeRealm);
        return securityManager;
    }

    @Bean(name = "employeeRealm")
    public EmployeeRealm employeeRealm() {
        return new EmployeeRealm();
    }

    /**
     *
     *
     * @description: 整合shiroDialect:用来整合shiro thymeleaf
     * @param null
     * @return:
     * @author: tanhao
     * @time: 2020/2/24 2:59
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
