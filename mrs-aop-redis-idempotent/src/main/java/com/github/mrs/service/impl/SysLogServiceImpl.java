package com.github.mrs.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.github.mrs.mapper.SysLogMapper;
import com.github.mrs.pojo.SysLog;
import com.github.mrs.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date: 2023/8/1 22:10
 * author: MR.孙
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    public int saveSyslog(SysLog sysLog) {
        boolean b = SqlHelper.retBool(sysLogMapper.insert(sysLog));
        return b ?  0 :  1;
    }
}
