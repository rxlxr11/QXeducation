package com.rxlxr.qxeducation.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @TableId
    private Integer id;
    private String name;
    private String gender;
    private int age;
    private  String qualification;
    private String subject;
    private  double salary;
    private String ability;
    private  String region;
    private  int year;
    private  String image;
}
