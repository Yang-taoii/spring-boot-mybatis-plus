package com.yangtao.springboot.entity;

import com.yangtao.springboot.enums.GenderEnum;
import lombok.Data;

/**
 * @author：杨涛
 * @create: 2021-03-05 13:02
 */

@Data
public class RoleVo {
    private Integer uid;
    private String roleName;
    private GenderEnum gender;
    private String countryName;

}
