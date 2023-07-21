package com.github.mrs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 动物类，普通if-else判断
 * date: 2023/7/21 10:50
 * author: MR.孙
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal {

    private String animalType;

    public void assertEat(String animalType) {
        if ("dog".equals(animalType)){
            System.out.println("吃骨头");
        } else if ("cat".equals(animalType)) {
            System.out.println("吃鱼干");
        } else if ("sheep".equals(animalType)) {
            System.out.println("吃草");
        }
    }

}
