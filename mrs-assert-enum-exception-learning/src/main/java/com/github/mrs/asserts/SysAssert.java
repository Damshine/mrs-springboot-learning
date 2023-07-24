package com.github.mrs.asserts;

/**
 * description:
 * date: 2023/7/24 10:17
 * author: MR.孙
 */
public enum SysAssert implements SystemExceptionAssert{
    SYSTEM_EXCEPTION(50000, "系统异常")
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    SysAssert(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
