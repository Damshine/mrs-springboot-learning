package com.github.mrs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * date: 2023/7/29 20:35
 * author: MR.孙
 */
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
// @Profile("pro")
@Data
public class Student {

    private String name;

    private Integer age;

    public String goClass() {
        return "去教室";
    }




}
