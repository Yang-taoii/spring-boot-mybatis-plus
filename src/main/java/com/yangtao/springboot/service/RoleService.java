package com.yangtao.springboot.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangtao.springboot.entity.Role;
import com.yangtao.springboot.entity.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author：杨涛
 * @create: 2021-03-03 19:25
 */
public interface RoleService extends IService<Role> {

    List<RoleVo> selectConditionPage(@Param("gender") Integer gender,
                                     @Param("countryid") Integer countryid,
                                     Page<RoleVo> page);

}
