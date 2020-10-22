package com.oktenweb.mar2020moviemvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieList {

  @JsonProperty("movies")
  private List<SingleMovie> movieList;
  private int totalElements;

}
