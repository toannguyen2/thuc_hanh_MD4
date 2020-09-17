package org.codegym.controller;

import org.codegym.model.City;
import org.codegym.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public String doGet(Model model){
        Iterable<City> lists = cityService.findAllByOrderByName();
        model.addAttribute("lists", lists);
        return "home";
    }
}
