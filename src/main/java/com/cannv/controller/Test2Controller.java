package com.cannv.controller;

import com.cannv.dto.ComputerDTO;
import com.cannv.model.Players;
import com.cannv.model.RequestModel.CreateComputerModel;
import com.cannv.model.RequestModel.CreatePlayerModel;
import com.cannv.repository.PlayersRepository;
import com.cannv.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Test2Controller {

    @Autowired
    private PlayersRepository playersRepository;
    @RequestMapping("/player")
    public String index(@RequestParam(value = "name", required = false, defaultValue = "") String name,Model model) {

        List<Players> list = this.playersRepository.findByplayerNameContains(name);
        model.addAttribute("lists",list);
        model.addAttribute("name",name);
        return "learn/test2/index";
    }
    @RequestMapping("/player/add")
    public String add(Model model) {
        CreatePlayerModel player = new CreatePlayerModel();
        model.addAttribute("player",player);
        return "learn/test2/add";
    }
    @RequestMapping(value = "/player/add", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute("player")CreatePlayerModel cplayer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "learn/test2/add";
        }
        Players player = new Players();
        player.setPlayerName(cplayer.getPlayerName());
        player.setAddress(cplayer.getAddress());
        player.setPositionPlay(cplayer.getPositionPlay());
        player.setGender(cplayer.getGender());
        player.setTeamName(cplayer.getTeamName());
        player.setTransportCost(cplayer.getTransportCost());
        player.setBirtday(cplayer.getBirtday());
        this.playersRepository.save(player);
        return "redirect:/player";
    }
    @RequestMapping(value = "player/delete/{id}")
    public String delete(@PathVariable Integer id){
        Players players = this.playersRepository.findOne(id);
        this.playersRepository.delete(players);
        return "redirect:/player";
    }
    @RequestMapping(value = "player/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Players player = this.playersRepository.findOne(id);
        model.addAttribute("player",player);
        return "learn/test2/edit";
    }
    @RequestMapping(value = "player/edit/{id}", method = RequestMethod.POST)
    public String editStore(@PathVariable Integer id,@Valid @ModelAttribute("player")CreatePlayerModel cplayer, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            return "learn/test2/edit";
        }
        Players player = this.playersRepository.findOne(id);
        player.setPlayerName(cplayer.getPlayerName());
        player.setAddress(cplayer.getAddress());
        player.setPositionPlay(cplayer.getPositionPlay());
        player.setGender(cplayer.getGender());
        player.setTeamName(cplayer.getTeamName());
        player.setTransportCost(cplayer.getTransportCost());
        player.setBirtday(cplayer.getBirtday());
        this.playersRepository.save(player);
        return "redirect:/player";
    }
    @RequestMapping(value = "player/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        Players player = this.playersRepository.findOne(id);
        model.addAttribute("player",player);
        return "learn/test2/view";
    }
}
