package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.vo.system.ValidateCodeVo;

public interface ValidateCodeService {

    //生成图片验证码
    ValidateCodeVo generateValidateCode();
}
