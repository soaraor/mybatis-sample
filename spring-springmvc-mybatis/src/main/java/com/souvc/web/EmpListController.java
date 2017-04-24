package com.souvc.web;


import com.souvc.dao.EmpDAO;
import com.souvc.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("emp")
public class EmpListController {

    private EmpDAO dao;

    @Autowired
    public void setDao(EmpDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/list")
    public String execute(Model model){
        List<Emp> list = dao.findAll();
        model.addAttribute("emps", list);
        return "emp_list";
    }

}
