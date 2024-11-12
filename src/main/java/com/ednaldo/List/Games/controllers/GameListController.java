package com.ednaldo.List.Games.controllers;

import com.ednaldo.List.Games.dto.GameDetails;
import com.ednaldo.List.Games.dto.GameSimpleDTO;
import com.ednaldo.List.Games.dto.ListGameDTO;
import com.ednaldo.List.Games.services.GameListService;
import com.ednaldo.List.Games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/listgames")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<ListGameDTO>> lisGames() {
        List<ListGameDTO> list = gameListService.listGames();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}/games")
    public ResponseEntity<List<GameSimpleDTO>> findByList(@PathVariable Long id) {
        List<GameSimpleDTO> byGameList = gameService.findByGameList(id);
        return ResponseEntity.ok().body(byGameList);
    }
}
