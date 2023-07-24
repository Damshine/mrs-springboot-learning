package com.github.mrs.po;

import com.github.mrs.asserts.Assert;
import lombok.Data;

/**
 * description:
 * date: 2023/7/22 20:52
 * author: MR.孙
 */
@Data
public class BaseResponse {

    /**
     * 返回码
     */
    protected int code;
    /**
     * 返回消息
     */
    protected String msg;

    public BaseResponse() {
        this(0, "成功");
    }

    public BaseResponse(Assert asserts) {
        this(asserts.getCode(), asserts.getMessage());
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.msg = message;
    }


}
