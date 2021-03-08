package com.yangtao.springboot.entity;

import com.yangtao.springboot.enums.GenderEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author：杨涛
 * @create: 2021-03-05 13:02
 */

@Data
public class RoleVo implements Serializable {

    private Integer uid;
    private String roleName;
    private GenderEnum gender;
    private String countryName;

}
