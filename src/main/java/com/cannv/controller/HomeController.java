package com.cannv.controller;


import com.cannv.dto.ComputerDTO;
import com.cannv.model.Computer;
import com.cannv.model.RequestModel.CreateComputerModel;
import com.cannv.service.ComputerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ComputerService computerService;
    @Autowired
    private ModelMapper mapper;

    @RequestMapping("/")
    public String home(Model model) {
//        List<ComputerDTO> list = this.computerService.getAll();
//        CreateComputerModel requestModel = new CreateComputerModel();
//        model.addAttribute("lists",list);
//        model.addAttribute("model",requestModel);
        return "index";
    }

    @RequestMapping(value = "/store", method =  RequestMethod.POST)
    public String storeComputer(@Valid @ModelAttribute("model")CreateComputerModel computerModel, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "index";
        }
        Computer computer = this.computerService.create(computerModel);
        return "index";
    }


}
