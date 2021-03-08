package com.yangtao.springboot.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author：杨涛
 * @create: 2021-03-05 10:55
 * 用于操作角色性别的枚举类
 */

public enum  GenderEnum {
    /**
     * 数据库 1 --> 男
     *       2 --> 女
     */
    MAN(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    private final Integer code;
    private final String message;

    GenderEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
