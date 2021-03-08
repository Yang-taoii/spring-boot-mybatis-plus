package com.yangtao.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangtao.springboot.entity.Role;
import com.yangtao.springboot.entity.RoleVo;
import com.yangtao.springboot.enums.GenderEnum;
import com.yangtao.springboot.mapper.RoleMapper;
import com.yangtao.springboot.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
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
//       Role role = new Role();
//       role.setUname("赵云");
//       role.setPassword("112333");
//       role.setCountryid(2);
//       roleMapper.insert(role);
//       log.info("role：{}",role);
    }


    @Test
    void Update() {
//        Role role = roleMapper.selectById(66);
//        role.setGender(GenderEnum.FEMALE);
//        roleMapper.updateById(role);
//        log.info("role：{}",role);
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
        roleMapper.deleteById(66);
    }

    @Test
    void selectConditionPage() {
        //实现带分页的多条件查询
        IPage<Role> iPage = new Page<>(1,3);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("gender",1);
        map.put("countryid",2);
        wrapper.allEq(map);
        roleMapper.selectPage(iPage,wrapper).getRecords().forEach(System.out::println);
    }

    @Test
    void selectConditionPage2() {
        //实现带分页的多条件查询
        IPage<Role> page = new Page<>(1,3);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("gender",1);
        map.put("countryid",2);
        wrapper.allEq(map);
        roleService.page(page,wrapper).getRecords().forEach(System.out::println);
    }

    @Test
    void selectConditionPage3() {

        roleMapper.selectConditionPage(0,3,new Page<>(2,3)).forEach(System.out::println);
        String s = Integer.toBinaryString(-8);
        log.info("--------------------------------> {}",s);
    }



}
