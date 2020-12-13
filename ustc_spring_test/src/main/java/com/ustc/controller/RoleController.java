package com.ustc.controller;

import com.ustc.domain.Role;
import com.ustc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.getRoleList();
        modelAndView.addObject("roleList",roleList);
        System.out.println(roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }
}
