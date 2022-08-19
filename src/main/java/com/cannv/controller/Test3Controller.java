package com.cannv.controller;


import com.cannv.model.Countrs;
import com.cannv.model.RequestModel.CreateCountryModel;
import com.cannv.repository.CountrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Test3Controller {
    @Autowired
    private CountrsRepository countrsRepository;
    @RequestMapping("/country")
    public String index(@RequestParam(value = "continent", required = false, defaultValue = "") String continent, Model model) {
        List<Countrs> list = this.countrsRepository.getQuery(continent);
        System.out.println(list);
        model.addAttribute("lists",list);
        return "learn/test3/index";
    }
    @RequestMapping("/country/add")
    public String add(Model model) {
        CreateCountryModel country = new CreateCountryModel();
        model.addAttribute("country",country);
        return "learn/test3/add";
    }
    @RequestMapping(value = "/country/add", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("country")CreateCountryModel ccountry, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "learn/test3/add";
        }
        Countrs countrs = new Countrs();
        countrs.setCode(ccountry.getCode());
        countrs.setArea(ccountry.getArea());
        countrs.setName(ccountry.getName());
        countrs.setContinent(ccountry.getContinent());
        countrs.setLanguage(ccountry.getLanguage());
        countrs.setDateCreate(ccountry.getDateCreate());;
        countrs.setPopulation(ccountry.getPopulation());
        this.countrsRepository.save(countrs);
        return "redirect:/country";
    }
    @RequestMapping(value = "country/delete/{id}")
    public String delete(@PathVariable Integer id){
        Countrs countrs = this.countrsRepository.findOne(id);
        this.countrsRepository.delete(countrs);
        return "redirect:/country";
    }
    @RequestMapping(value = "country/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Countrs countrs = this.countrsRepository.findOne(id);
        model.addAttribute("country",countrs);
        return "learn/test3/edit";
    }
    @RequestMapping(value = "country/edit/{id}", method = RequestMethod.POST)
    public String editStore(@PathVariable Integer id,@Valid @ModelAttribute("country")CreateCountryModel ccountry, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            return "learn/test3/edit";
        }
        Countrs countrs = this.countrsRepository.findOne(id);
        ;
        countrs.setCode(ccountry.getCode());
        countrs.setArea(ccountry.getArea());
        countrs.setName(ccountry.getName());
        countrs.setContinent(ccountry.getContinent());
        countrs.setLanguage(ccountry.getLanguage());
        countrs.setDateCreate(ccountry.getDateCreate());;
        countrs.setPopulation(ccountry.getPopulation());
        this.countrsRepository.save(countrs);
        return "redirect:/country";
    }
    @RequestMapping(value = "country/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        Countrs countrs = this.countrsRepository.findOne(id);
        model.addAttribute("country",countrs);
        return "learn/test3/view";
    }
}
