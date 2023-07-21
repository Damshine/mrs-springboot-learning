package com.github.mrs;

/**
 * description: 使用枚举 + 接口实现，消除if-else
 * date: 2023/7/21 11:07
 * author: MR.孙
 */
public enum AnimalEnums implements Eat {

    Dog() {
        @Override
        public String eat() {
            return "狗吃骨头";
        }
    },
    Cat() {
        @Override
        public String eat() {
            return "猫吃鱼干";
        }
    },
    Sheep() {
        @Override
        public String eat() {
            return "羊吃草";
        }
    };


}
