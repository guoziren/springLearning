package com.ustc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustc.domain.User;
import com.ustc.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    /**
     * 页面跳转，且携带参数
     */
    @RequestMapping("/user")
    public String save() {
        System.out.println("save running");
        return "success.jsp";
    }

    /**
     * 页面跳转
     */
    @RequestMapping("/fail")
    public String fail(){
        return "fail";
    }

    /**
     * 页面跳转，且携带参数
     */
    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据  jsp中通过${name}取
        modelAndView.addObject("name","zhangsan");
        // 设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 页面跳转，且携带参数
     */
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","wangwu");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 页面跳转，且携带参数
     */
    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("key4","value4");
        return "success";
    }

    /**
     * 页面跳转，且携带参数
     */
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest servletRequest){
        servletRequest.setAttribute("key5","value5");
        return "success";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse servletResponse) throws IOException {
       servletResponse.getWriter().println("/quick6");
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() throws IOException {
        return "/quick7";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"zhangshan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User("aishang",25);
        // json转换工具将对象转为Json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    //期望SpringMVC将User转化成json字符串
    public User save10() {
        User user = new User("aishang",25);
        return user;
    }

    /**
     * 获取请求参数，请求参数名须与业务方法参数名一致
     */
    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println("username = " + username + ", age = " + age);
    }

    /**
     * 获取对象参数
     */
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    /**
     * 获取数组参数
     */
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    /**
     * 获取集合参数-1
     */
    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    /**
     * 获取集合参数-2
     */
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> users) {
        System.out.println(users);
    }

    /**
     * 业务方法参数名于请求中的参数名不一致时
     */
    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = true, defaultValue = "abc") String username) {
        System.out.println(username);
    }

    /**
     * restful 风格 获取参数
     */
    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "name") String username) {
        System.out.println(username);
    }

    /**
     * 自定义转换器
     */
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(@RequestParam(name = "date") String username) {
        System.out.println(username);
    }

    /**
     * 获取请求头
     */
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent") String header) {
        System.out.println(header);
    }

    /**
     * 获取cookie
     */
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@CookieValue(value = "JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
    }

    /**
     * 上传单个文件
     * @param username
     * @param uploadFile 上传的文件被封装为MultipartFile对象，此参数名要和表单中type为file 的input标签的name一致
     */
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        String filename = uploadFile.getOriginalFilename();
        System.out.println(filename);
        // c:\\upload目录得存在,否则500
        uploadFile.transferTo(new File("C:\\upload" + File.separator + filename ));
    }
}
