package com.yangtao.springboot.controller;

import com.yangtao.springboot.entity.Role;
import com.yangtao.springboot.service.RoleService;
import com.yangtao.springboot.view.MyExcelView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 实现查询数据自动生成excel表格内容
 *
 * @author：杨涛
 * @create: 2021-03-12 16:10
 */
@Slf4j
@Controller
public class ExcelDownloadController {
    @Autowired
    private RoleService roleService;


    @RequestMapping("/downloadList")
    public ModelAndView downloadList() {

        List<Role> list = roleService.list();
        log.info("将要导出的信息：----> {}", list);

        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setView(new MyExcelView());

        return mv;
    }
}
