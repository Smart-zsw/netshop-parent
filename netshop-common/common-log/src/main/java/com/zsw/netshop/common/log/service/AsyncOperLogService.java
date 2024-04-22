package com.zsw.netshop.common.log.service;

import com.zsw.netshop.model.entity.system.SysOperLog;

public interface AsyncOperLogService {

    public abstract void saveSysOperLog(SysOperLog sysOperLog);
}
