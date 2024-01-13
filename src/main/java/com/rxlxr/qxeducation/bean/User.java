package com.rxlxr.qxeducation.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId
    private Integer id;
    private String username;
    private  String password;
    private  double price;
    private  String region;
    private  String email;
    private  String image;

}
