package com.yangtao.springboot.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.yangtao.springboot.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yangtao
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

  @TableId
  private long uid;
  private String uname;
  private String password;
  private long countryid;

  //执行insert时，自动添加
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  //执行insert/update时，自动添加
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  //枚举类的 gender 需要与数据库字段名相同
  // 不同时使用注解 @TableField(value = "")
  private GenderEnum gender;

  @TableLogic
  private Integer deleted;

}
