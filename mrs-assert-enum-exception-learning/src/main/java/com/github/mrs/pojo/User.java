package com.github.mrs.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * date: 2023/7/22 20:07
 * author: MR.孙
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String name;

    private String password;

    private String age;

}
