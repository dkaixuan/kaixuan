package cn.test;

import cn.dao.DepartmentMapper;
import cn.dao.EmployeeMapper;
import cn.entity.Department;
import cn.entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SqlSession sqlSession;
    @Test
    public void testCrud() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper bean = applicationContext.getBean(DepartmentMapper.class);
//        new Department();
//        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"666"));
//        departmentMapper.insertSelective(new Department(null, "777"));
//        employeeMapper.insertSelective(new Employee(null,1,"111","111","111"));

          EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
           String uid= UUID.randomUUID().toString().substring(0, 5)+i;
            employeeMapper.insertSelective(new Employee(null,1,"111",uid,uid+"670973127@qq.com"));
        }
    }
}
