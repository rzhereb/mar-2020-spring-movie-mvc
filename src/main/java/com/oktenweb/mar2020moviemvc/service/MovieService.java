package com.oktenweb.mar2020moviemvc.service;

import com.oktenweb.mar2020moviemvc.dto.MovieList;
import com.oktenweb.mar2020moviemvc.dto.SingleMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Service
public class MovieService {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${movies.username}")
  private String username;
  @Value("${movies.password}")
  private String password;

  public MovieList getAllMovies() {

//    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", "Basic " +
        Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

    HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
    final ResponseEntity<MovieList> responseEntity = restTemplate
        .exchange("http://localhost:8081/movies?size=10", HttpMethod.GET, httpEntity, MovieList.class);

    if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.hasBody()) {
      return responseEntity.getBody();
    } else {
      throw new RuntimeException("Unsuccessful request!");
    }
  }

  public void saveMovie(SingleMovie singleMovie) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", "Basic " +
        Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

    HttpEntity<?> httpEntity = new HttpEntity<>(singleMovie, httpHeaders);
    final ResponseEntity<SingleMovie> responseEntity = restTemplate
        .exchange("http://localhost:8081/movies/directors/1", HttpMethod.POST, httpEntity, SingleMovie.class);

    if (responseEntity.getStatusCode() != HttpStatus.CREATED) {
      throw new RuntimeException("Unsuccessful request!");
    }
  }
}
