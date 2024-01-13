package com.rxlxr.qxeducation.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rxlxr.qxeducation.bean.Form;
import com.rxlxr.qxeducation.mapper.OrderMapper;
import com.rxlxr.qxeducation.mapper.TeacherMapper;
import com.rxlxr.qxeducation.mapper.UserMapper;
import com.rxlxr.qxeducation.bean.Order;
import com.rxlxr.qxeducation.bean.Teacher;
import com.rxlxr.qxeducation.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Slf4j
@Repository
public class QXRepo{


    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private TeacherMapper teacherMapper;
    @Autowired(required = false)
    private OrderMapper orderMapper;

    public User queryUser(String username, String password){

        Map<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        log.info(map.toString());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map);
        User user_find = userMapper.selectOne(wrapper);

        return user_find;
    }


    public int insertUser(User user){
        return userMapper.insert(user);
    }
    public List<Teacher> queryTeacher(Map map){
        Map map1 = new HashMap<>();
//        map1.put("qualification",form.getQualification());
//        map1.put("gender",form.getGender());
//        map1.put("subject",form.getSubject());
//        map1.put("region",form.getRegion());
        map1.putAll(map);
        map1.remove("age_start");
        map1.remove("age_end");
        map1.remove("salary_start");
        map1.remove("salary_end");

        log.info("queryTeacher");
        log.info(map1.toString());

        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.allEq(map1,false);
        wrapper.between("age",map.get("age_start"),map.get("age_end"));
        wrapper.between("salary",map.get("salary_start"),map.get("salary_end"));

        log.info(wrapper.getSqlSelect());
        List<Teacher> teachers = teacherMapper.selectList(wrapper);
        return teachers;
    }

    public List<Order> queryOrder(int user_id){
        log.info("queryOrder");
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",user_id);
        List<Order> orders = new ArrayList<>();
        orders = orderMapper.selectList(wrapper);
        return orders;
    }

}
