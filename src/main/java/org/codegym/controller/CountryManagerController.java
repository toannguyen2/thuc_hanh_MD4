package org.codegym.controller;

import org.codegym.model.Country;
import org.codegym.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CountryManagerController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/country")
    public String doGetCountry(Model model){
        Iterable<Country> list = countryRepository.findAllByOrderByName();
        model.addAttribute("list", list);
        return "/manager/country/list";
    }

    @GetMapping("/country/add")
    public String doGet(Model model){
        model.addAttribute("country", new Country());
        return "manager/country/add";
    }

    @PostMapping("/country/add")
    public String doPost(Country country, RedirectAttributes redirectAttributes) {
        countryRepository.save(country);
        redirectAttributes.addFlashAttribute("success", "Thêm quốc gia thành công");
        return "redirect:/country";
    }

    @GetMapping("/country/edit/{id}")
    public String doGetEdit(@PathVariable("id") Long id, Model model){
        Optional<Country> optionalCountry = countryRepository.findById(id);

        if (optionalCountry.isPresent()){
            Country country = optionalCountry.get();
            model.addAttribute("country", country);
            return "manager/country/edit";
        }

        return "redirect:/country";
    }

    @PostMapping("/country/edit/{id}")
    public String doPostEdit(@PathVariable("id") Long id, @ModelAttribute("country") Country country, Model model){
        model.addAttribute("success", "Edit success");
        countryRepository.save(country);
        return "manager/country/edit";
    }

    @GetMapping("/country/delete/{id}")
    public String doGetDelete(@PathVariable("id") Long id, Model model){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if (optionalCountry.isPresent()){
            Country country = optionalCountry.get();
            model.addAttribute("country", country);
            return "manager/country/delete";
        }
        return "redirect:/country";
    }

    @PostMapping("/country/delete/{id}")
    public String doPostDelete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        countryRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Delete success.");
        return "redirect:/country";
    }
}
