package com.github.mrs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * date: 2023/7/20 14:38
 * author: MR.孙
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {

    private String name;
    private int age;
    private String gender;
    private Double height;
    private String birthday;
    private String course;

}
