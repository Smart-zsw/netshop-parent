package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.common.log.service.AsyncOperLogService;
import com.zsw.netshop.manager.mapper.SysOperLogMapper;
import com.zsw.netshop.model.entity.system.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsyncOperLogServiceImpl implements AsyncOperLogService {

    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    //保存日志数据
    @Override
    public void saveSysOperLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insert(sysOperLog);
    }
}
