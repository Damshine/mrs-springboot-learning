package com.github.mrs.asserts;

import com.github.mrs.exception.BaseException;
import com.github.mrs.exception.BusinessException;

import java.text.MessageFormat;

/**
 * description:
 * date: 2023/7/22 19:37
 * author: MR.孙
 */
public interface BusinessExceptionAssert extends IAssert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(args, msg, t);
    }

}
