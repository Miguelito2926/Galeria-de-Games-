package com.ednaldo.List.Games.controllers;

import com.ednaldo.List.Games.dto.GameDetails;
import com.ednaldo.List.Games.entities.Game;
import com.ednaldo.List.Games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDetails>> listGames() {
       List<GameDetails> list = gameService.findAll();
       return ResponseEntity.ok().body(list);
    }
}
