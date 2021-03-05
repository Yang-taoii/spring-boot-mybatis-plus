package com.yangtao.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangtao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

  private long countryid;
  private String countryName;


}
