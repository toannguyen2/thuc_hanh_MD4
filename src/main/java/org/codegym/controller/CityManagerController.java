package org.codegym.controller;

import org.codegym.model.City;
import org.codegym.model.Country;
import org.codegym.repository.CountryRepository;
import org.codegym.service.city.CityService;
import org.codegym.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CityManagerController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/add")
    public String doGet(Model model)
    {
        Iterable<Country> listCountry = countryService.findAllByOrderByName();
        model.addAttribute("city", new City());
        model.addAttribute("listCountry", listCountry);
        return "manager/city/add";
    }

    @PostMapping("/add")
    public String doPostAdd(@ModelAttribute("city") City city, RedirectAttributes redirectAttributes)
    {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("success", "Add city success.");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String doGetEdit(@PathVariable("id") Long id, Model model) {
        Iterable<Country> listCountry = countryService.findAllByOrderByName();

        Optional<City> optionalCity = cityService.findById(id);
        if (optionalCity.isPresent()){
            City city = optionalCity.get();
            model.addAttribute("city", city);
            model.addAttribute("listCountry", listCountry);
            return "manager/city/edit";
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String doPostEdit(@PathVariable("id") Long id, @ModelAttribute("city") City city, Model model) {
        Optional<City> optionalCity = cityService.findById(id);
        if (optionalCity.isPresent()){
            Iterable<Country> listCountry = countryService.findAllByOrderByName();
            cityService.save(city);
            model.addAttribute("listCountry", listCountry);
            model.addAttribute("success", "Update success.");

            return "manager/city/edit";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String doGetDelete(@PathVariable("id") Long id, Model model) {
        Optional<City> optionalCity = cityService.findById(id);
        if (optionalCity.isPresent()){
            City city = optionalCity.get();
            model.addAttribute("city", city);
            return "manager/city/delete";
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String doPostDelete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        cityService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Delete success.");
        return "redirect:/";
    }

    @GetMapping("/city/{id}")
    public String doGetDetail(@PathVariable("id") Long id, Model model) {
        Optional<City> optionalCity = cityService.findById(id);
        if (optionalCity.isPresent()){
            City city = optionalCity.get();
            model.addAttribute("city", city);
            return "manager/city/detail";
        }
        return "redirect:/";
    }
}
