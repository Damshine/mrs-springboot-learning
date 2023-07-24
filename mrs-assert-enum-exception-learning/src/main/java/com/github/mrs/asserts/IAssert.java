package com.github.mrs.asserts;

import com.github.mrs.exception.BaseException;

/**
 * description: 断言类
 * date: 2023/7/22 19:07
 * author: MR.孙
 */
public interface IAssert {

    int getCode();

    String getMessage();

    /**
     * 创建异常
     * @param args
     * @return
     */
    BaseException newException(Object... args);

    /**
     * 创建异常
     * @param t
     * @param args
     * @return
     */
    BaseException newException(Throwable t, Object... args);


    /**
     *  断言对象 如果为空抛出异常
     * @param obj 要判断的对象
     */
    default void assertNotNull(Object obj) {

        if (obj == null) {
            throw newException(obj);
        }

    }


    /**
     * 断言对象 如果为空，则抛出异常
     * 异常信息， 支持参数传递，避免判断之前进行字符串拼接操作
     * @param obj
     * @param args
     */
    default void assertNotNull(Object obj, Object... args) {

        if (obj == null) {
            throw newException(args);
        }

    }

}
