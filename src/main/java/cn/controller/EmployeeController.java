package cn.controller;

import cn.entity.Employee;
import cn.entity.Message;
import cn.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理员工 crud
 */

@Controller
public class EmployeeController {

    @Autowired
     EmployeeService employeeService;

    @RequestMapping("/emps")
    @ResponseBody
    public Message getEmpsWithJson(@RequestParam(value = "pn",defaultValue ="1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List <Employee> list=employeeService.findAll();
        PageInfo page=new PageInfo(list,5);
        return Message.success().add("pageInfo",page);
    }



    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue ="1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List <Employee> list=employeeService.findAll();
        PageInfo page=new PageInfo(list,5);


        model.addAttribute("pageInfo", page);
        return "list";
    }

}
