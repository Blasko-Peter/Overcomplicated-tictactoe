package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import com.codecool.enterprise.overcomplicated.service.ComicsService;
import com.codecool.enterprise.overcomplicated.service.FunFactService;
import com.codecool.enterprise.overcomplicated.service.PlayerService;
import com.codecool.enterprise.overcomplicated.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    @Autowired
    private FunFactService funFactService;

    @Autowired
    private ComicsService comicsService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private StepService stepService;

    @ModelAttribute("player")
    public Player getPlayer() {
        return playerService.getPlayer();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return playerService.getPlayer().getImage();
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        playerService.newImage();
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        model.addAttribute("funfact", funFactService.addCNFunFact());
        model.addAttribute("comic_uri", comicsService.addComic());
        model.addAttribute("steps", stepService.getStepVisual());
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        System.out.println("Player moved " + move);
        stepService.addStep(move, 'X');
        stepService.addMachineStep();
        return "redirect:/game";
    }

}
