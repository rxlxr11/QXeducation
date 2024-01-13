package com.rxlxr.qxeducation.service;


import com.rxlxr.qxeducation.bean.Form;
import com.rxlxr.qxeducation.bean.Order;
import com.rxlxr.qxeducation.bean.Response;
import com.rxlxr.qxeducation.bean.User;

import com.rxlxr.qxeducation.repo.QXRepo;
import com.rxlxr.qxeducation.util.ObjToMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class QXService {
    @Autowired
    private QXRepo qxRepo;
    public Response userData(String username,String password)  {
        Response response = new Response();
        User user_find = qxRepo.queryUser(username,password);
        response.setData(user_find);
        if (user_find == null) {
            response.setErrorMsg("cant find");
            response.setErrorCode(-1);
        }
        else {
            response.setErrorMsg("success");
            response.setErrorCode(0);
        }
        return response;
    }

    public Response registerUser(User user)  {

        Response response = new Response();
        Integer user_id = Integer.valueOf(qxRepo.insertUser(user));
        response.setData(user_id);
        if (user_id.intValue() == 0) {
            response.setErrorMsg("cant insert");
            response.setErrorCode(-1);
        }
        else {
            response.setErrorMsg("success");
            response.setErrorCode(0);
        }
        return response;
    }

    public Response TeachersData(Form form)  {
        Response response = new Response();
        if (form.getAge_start() == null)
            form.setAge_start(0);
        if (form.getAge_end() == null)
            form.setAge_end(100);
        if (form.getSalary_start() == null)
            form.setSalary_start(0.0);
        if (form.getSalary_end() == null)
            form.setAge_start(100000);
        Map map = ObjToMap.convertObjectToMap(form);
        response.setData(qxRepo.queryTeacher(map));
        response.setErrorMsg("success");
        response.setErrorCode(0);
        return response;
    }

    public Response orderData(int user_id)  {
        Response response = new Response();
        List<Order> orders = qxRepo.queryOrder(user_id);
        response.setData(qxRepo.queryOrder(user_id));
        response.setErrorMsg("success");
        response.setErrorCode(0);
        return response;
    }

}
