package com.rxlxr.qxeducation.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Form {
    private String gender;
    private Integer age_start;
    private Integer age_end;

    private Double salary_start;
    private Double salary_end;
    private String region;
    private String subject;
    private String qualification;
}
