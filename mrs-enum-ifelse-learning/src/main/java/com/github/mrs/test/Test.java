package com.github.mrs.test;

import com.github.mrs.enums.Week;

/**
 * description: 枚举入门测试1
 * date: 2023/7/21 10:16
 * author: MR.孙
 */
public class Test {

    public static void main(String[] args) {
        Week week = Week.MONDAY;
        System.out.println(week.getWeekNum());

        for (Week w : Week.values()) {
            System.out.println(w);
        }
        System.out.println("星期天：" + Week.valueOf("SUNDAY"));

    }

}
