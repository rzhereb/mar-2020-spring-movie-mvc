package com.oktenweb.mar2020moviemvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SingleMovie {

  private int id;
  private String title;
  private int duration;

}
