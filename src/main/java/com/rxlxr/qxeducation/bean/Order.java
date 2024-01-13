package com.rxlxr.qxeducation.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order_qx")
public class Order {
    @TableId
    private Integer id;
    private Integer userId;
    private Integer teacherId;
    private String state;
    private  double price;
    private Date time;
    private  int during;
}
