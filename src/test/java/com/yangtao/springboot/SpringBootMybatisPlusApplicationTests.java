package com.yangtao.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yangtao.springboot.entity.Role;
import com.yangtao.springboot.enums.GenderEnum;
import com.yangtao.springboot.mapper.RoleMapper;
import com.yangtao.springboot.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    RoleService roleService;
    @Autowired
    RoleMapper roleMapper;

    @Test
    void contextLoads() {
       Role role = new Role();
       role.setUname("赵云");
       role.setPassword("112333");
       role.setCountryid(2);
       roleMapper.insert(role);
       log.info("role：{}",role);
    }


    @Test
    void Update() {
        Role role = roleMapper.selectById(66);
        role.setGender(GenderEnum.FEMALE);
        roleMapper.updateById(role);
        log.info("role：{}",role);
    }


    @Test
    void Select() {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender",2);
        roleMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    void Delete() {
        //逻辑删除功能
        roleMapper.deleteById(70);
    }
}
