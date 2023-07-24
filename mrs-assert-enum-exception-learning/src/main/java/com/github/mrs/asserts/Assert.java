package com.github.mrs.asserts;


public enum Assert implements BusinessExceptionAssert {


    BUSINESS_EXCEPTION(50001, "业务异常"),

    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;


    Assert(int code, String message) {
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
