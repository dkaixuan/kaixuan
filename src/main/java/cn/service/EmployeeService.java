package cn.service;

import cn.dao.EmployeeMapper;
import cn.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
     EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> findAll() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
