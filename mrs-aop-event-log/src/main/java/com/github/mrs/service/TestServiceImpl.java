package com.github.mrs.service;

import com.github.mrs.entity.SysLog;
import com.github.mrs.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date: 2023/7/27 14:38
 * author: MR.孙
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestMapper testMapper;

    @Override
    public int saveLog(SysLog sysLog) {
        return testMapper.insert(sysLog);

    }

}
