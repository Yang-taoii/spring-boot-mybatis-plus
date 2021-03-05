package com.yangtao.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangtao.springboot.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author：杨涛
 * @create: 2021-03-03 18:52
 * 使用 mybatis-plus 中自带的接口方法
 */

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {


}
