package com.controller;

import com.model.User;
import com.server.AsyncLogic;
import com.server.BaseDemoBean;
import com.server.DemoLogic;
import com.storage.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
public class DemoController {
    @Autowired
    private DemoLogic demoLogic;
    @Autowired
    private AsyncLogic asyncLogic;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("bean1")
    private BaseDemoBean demoBean;

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public @ResponseBody String demo(
            @RequestParam(value = "id") String id
    ) {
        return demoBean.getMessage();
    }

    @RequestMapping(value = "/async",method = RequestMethod.GET)
    public  String asuncTest(
            @RequestParam(value = "id", defaultValue = "0") String id
    ) {
         asyncLogic.async();
         return "/demo2";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public @ResponseBody
    User getUser(
            @RequestParam(value = "name", defaultValue = "0") String name
    ) {
        System.out.println(userRepository.findByUserName(name).getUserName());
        return userRepository.findByUserName(name);
    }

    @RequestMapping(value = "/user/save",method = RequestMethod.GET)
    public @ResponseBody
    User saveUser(
            @RequestParam(value = "name", defaultValue = "0") String name,
            @RequestParam(value = "password", defaultValue = "0") String password
    ) {
        User user = new User();
        user.setPassWord(password);
        user.setUserName(name);
        return userRepository.save(user);
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUsers(
    ) {
        return userRepository.findAll();
    }
}
