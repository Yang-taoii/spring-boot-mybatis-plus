package com.yangtao.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangtao.springboot.entity.RoleVo;
import com.yangtao.springboot.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author：杨涛
 * @create: 2021-03-06 08:34
 */
@Slf4j
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/page")
    @ResponseBody
    public List<RoleVo> page(Integer gender, Integer countryId, String current, Model model){
        Page<RoleVo> page = new Page<>();
        page.setSize(5);
        if (current == null || "".equals(current)){
            current = "1";
        }
        page.setCurrent(Long.parseLong(current)) ;
        List<RoleVo> roleVos = roleService.selectConditionPage(gender, countryId, page);
        log.info("集合roleVos {}",roleVos);
        model.addAttribute("roles",roleVos);
        return roleVos;
    }


}
