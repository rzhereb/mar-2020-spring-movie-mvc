package com.oktenweb.mar2020moviemvc.controller;

import com.oktenweb.mar2020moviemvc.dto.SingleMovie;
import com.oktenweb.mar2020moviemvc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MovieViewController {

  @Autowired
  private MovieService movieService;

  @RequestMapping(method = RequestMethod.GET, value = "/")
  public String index(Model model) {
//    model.addAttribute("atr1", "Ababafdsfasdgfdsgfsdfkjnsdf");
    model.addAttribute("movies", movieService.getAllMovies());
    model.addAttribute("newMovie", new SingleMovie());
    return "index";
  }

  @PostMapping("/movie")
  public String saveMovie(@ModelAttribute SingleMovie singleMovie) {
    movieService.saveMovie(singleMovie);
    return "redirect:/";
  }

}
