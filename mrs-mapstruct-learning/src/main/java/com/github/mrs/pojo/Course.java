package com.github.mrs.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * date: 2023/7/20 15:36
 * author: MR.孙
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Course {

    private String courseName;
    private int sortNo;
    private long id;

}
