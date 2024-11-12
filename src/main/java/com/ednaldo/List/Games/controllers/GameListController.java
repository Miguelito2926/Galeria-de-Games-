package com.ednaldo.List.Games.controllers;

import com.ednaldo.List.Games.dto.ListGameDTO;
import com.ednaldo.List.Games.repositories.GameListRepository;
import com.ednaldo.List.Games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/listgames")
public class GameListController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<ListGameDTO>> lisGames() {
        List<ListGameDTO> list = gameService.listGames();

        return ResponseEntity.ok().body(list);
    }
}
