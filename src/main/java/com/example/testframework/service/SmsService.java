package com.example.testframework.service;

import cn.hutool.core.util.RandomUtil;
import com.example.testframework.utils.RedisUtil;
import com.huang.framework.authority.service.AbstractCheckSmsCode;
import com.huang.framework.exception.ServiceException;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author -Huang
 * @create 2020-03-15 18:37
 */
@Service
@Logger
public class SmsService implements AbstractCheckSmsCode {
    public final static String MOBILE_SMS_CODE = "MOBILE_SMS_CODE";
    private static final Integer CODE_LEN=6;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 校验验证码
     * @param mobile
     * @param code
     */
    @Override
    public Boolean checkCode(String mobile, String code) {
        String s = redisUtil.get(MOBILE_SMS_CODE + mobile);
        if(null == s || !code.equals(s)){
            redisUtil.del(MOBILE_SMS_CODE + mobile);
            throw new ServiceException("验证码错误");
        }
        redisUtil.del(MOBILE_SMS_CODE + mobile);
        return true;
    }

    /**
     * 模拟发送
     * @param mobile
     */
    public String send(String mobile) {
        String code = getCode();
        redisUtil.set(MOBILE_SMS_CODE + mobile, code );
        return code;
    }



    /**
     * 获得随机的code
     * @return
     */
    private String getCode() {
        StringBuilder code=new StringBuilder();
        for (int i = 0; i < CODE_LEN; i++) {
            code.append(RandomUtil.randomInt(0,9));
        }
        return code.toString();
    }
}
