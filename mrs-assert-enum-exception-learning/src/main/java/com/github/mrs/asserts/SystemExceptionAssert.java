package com.github.mrs.asserts;

import com.github.mrs.exception.BaseException;
import com.github.mrs.exception.SystemException;

import java.text.MessageFormat;

public interface SystemExceptionAssert extends IAssert{

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new SystemException(args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new SystemException(args, msg, t);
    }
}
