package com.yangtao.springboot.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangtao.springboot.entity.Role;
import com.yangtao.springboot.entity.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * @author：杨涛
 * @create: 2021-03-03 18:52
 * 使用 mybatis-plus 中自带的接口方法
 */

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleVo> selectConditionPage(@Param("gender") Integer gender,
                                     @Param("countryid") Integer countryid,
                                     Page<RoleVo> page);


}
