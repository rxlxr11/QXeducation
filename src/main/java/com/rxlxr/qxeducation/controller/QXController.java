package com.rxlxr.qxeducation.controller;

import com.rxlxr.qxeducation.bean.Form;
import com.rxlxr.qxeducation.bean.Response;
import com.rxlxr.qxeducation.bean.User;
import com.rxlxr.qxeducation.service.QXService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class QXController {
    @Autowired
    private QXService service;

    @CrossOrigin
    @RequestMapping("/login")
    public Response login(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password){
        log.info("login");
        Response response = service.userData(username,password);
        log.info(response.toString());
        return response;
    }

    @CrossOrigin
    @RequestMapping("/register")
    public Response register(@RequestBody User user){
        log.info("register"+user.toString());
        Response response = service.registerUser(user);
        log.info(response.toString());
        return response;
    }

    @CrossOrigin
    @RequestMapping("/getTeachers")
    public Response getTeachers(@RequestBody Form form){
        log.info("getTeachers"+form.toString());
        Response response = service.TeachersData(form);
//        log.info(response.toString());
        return response;
    }



    @CrossOrigin
    @RequestMapping("/getOrder")
    public Response getOrder(@RequestParam("user_id") String user_id){
        log.info("Order" + user_id);
        Response response = service.orderData(Integer.parseInt(user_id));
        log.info(response.toString());
        return response;
    }

}
