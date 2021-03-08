package com.yangtao.springboot.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangtao.springboot.entity.Role;

import com.yangtao.springboot.entity.RoleVo;
import com.yangtao.springboot.mapper.RoleMapper;
import com.yangtao.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author：杨涛
 * @create: 2021-03-03 18:42
 */

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleVo> selectConditionPage(Integer gender, Integer countryid, Page<RoleVo> page) {
        return roleMapper.selectConditionPage(gender,countryid,page);
    }
}
