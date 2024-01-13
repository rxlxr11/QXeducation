package com.rxlxr.qxeducation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxlxr.qxeducation.bean.Order;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface OrderMapper extends BaseMapper<Order> {


    @Select("select * from `order` where `user_id`= 1 ")
    ArrayList<Order> queryOrder(int user_id);

}
