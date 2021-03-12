package com.yangtao.springboot.view;

import com.yangtao.springboot.entity.Role;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 自定义的视图类 用于Excel表格的生成
 *
 * @author：杨涛
 * @create: 2021-03-12 16:14
 */

@Component
public class MyExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置名称
        String fileName = "role.xls";

        //设置下载头信息
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);

        //创建一个sheet对象
        Sheet sheet = workbook.createSheet("全部角色信息表");
        //设置sheet信息
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("uid");
        row.createCell(2).setCellValue("uname");
        row.createCell(3).setCellValue("password");
        row.createCell(4).setCellValue("CountryId");
        row.createCell(5).setCellValue("createTime");
        row.createCell(6).setCellValue("updateTime");
        if (model == null) {
            return;
        } else {
            List<Role> list = (List<Role>) model.get("list");


            for (int i = 0; i < list.size(); i++) {
                Role role = list.get(i);
                Row tempRow = sheet.createRow(i + 1);
                tempRow.createCell(0).setCellValue(i + 1);
                tempRow.createCell(1).setCellValue(role.getUid());
                tempRow.createCell(2).setCellValue(role.getUname());
                tempRow.createCell(3).setCellValue(role.getPassword());
                tempRow.createCell(4).setCellValue(role.getCountryid());
                if (role.getCreateTime() != null) {
                    tempRow.createCell(5).setCellValue(role.getCreateTime());
                }
                if (role.getUpdateTime() != null) {
                    tempRow.createCell(6).setCellValue(role.getUpdateTime());
                }
                //tempRow.createCell(5).setCellValue(role.getCreateTime());
                //tempRow.createCell(6).setCellValue(role.getUpdateTime());
            }

            //输出信息
            ServletOutputStream out = response.getOutputStream();

            workbook.write(out);
            System.out.println("表格生成成功");
            out.flush();
            out.close();
        }
    }
}
