package badwomen.mapper;

import badwomen.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 20:53
 */
@Mapper
public interface EmployeeListMapper {
    List<Employee> selectListEmployee(Integer offset, Integer size);
    int count();
}
