package com.github.mrs.enums;

/**
 * 枚举【抽象方法】
 */
public enum Week2 {

    SUNDAY(){
        @Override
        public void getWeekNum() {
            System.out.println(7);
        }
    },
    MONDAY() {
        @Override
        public void getWeekNum() {
            System.out.println("星期一");
        }
    },

    TUESDAY(){
        @Override
        public void getWeekNum() {
            System.out.println("礼拜二");
        }
    },
    WEDNESDAY(){
        @Override
        public void getWeekNum() {
            System.out.println("周三");
        }
    };


    public abstract void getWeekNum();

}
