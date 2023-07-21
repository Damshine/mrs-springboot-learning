package com.github.mrs.enums;

/**
 * 枚举类成员
 */
public enum Week {

    SUNDAY(7), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

    private int weekNum;

    Week(int weekNum){
        this.weekNum = weekNum;
    }

    public int getWeekNum() {
        return weekNum;
    }
}
