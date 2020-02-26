package badwomen;

import badwomen.serviceimpl.EmployeeListServiceImpl;
import badwomen.serviceimpl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BadwomenApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(BadwomenApplicationTests.class);

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    EmployeeListServiceImpl employeeListService;



    @Test
    void contextLoads() {
        //批量插入员工数据
        /*for (int i = 10; i < 100; i++) {
            String[] pwd = Md5Hash.encryptPassword("root");
            String[] emp = {"root"+i,pwd[0],pwd[1],"role:null"};
            employeeService.test("root0"+i,pwd[1],pwd[0],"role:null");
        }*/
        //System.out.println(employeeListService.list(10, 10));
    }

}
