package badwomen.serviceimpl;

import badwomen.dto.PaginationDTO;
import badwomen.mapper.EmployeeListMapper;
import badwomen.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 20:58
 */
@Service
public class EmployeeListServiceImpl {
    @Autowired
    EmployeeListMapper employeeListMapper;

    public PaginationDTO list(Integer page, Integer size) {


        PaginationDTO paginationDTO = new PaginationDTO();
        //总条数
        Integer totalCount = employeeListMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Employee> employees = employeeListMapper.selectListEmployee(offset, size);
        //List<QuestionDTO> questionDTOList = new ArrayList<>();

        /*for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }*/


        paginationDTO.setEmployees(employees);
        return paginationDTO;
    }
}
