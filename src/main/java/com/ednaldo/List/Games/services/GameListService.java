package com.ednaldo.List.Games.services;

import com.ednaldo.List.Games.dto.GameSimpleDTO;
import com.ednaldo.List.Games.dto.ListGameDTO;
import com.ednaldo.List.Games.entities.GameList;
import com.ednaldo.List.Games.repositories.GameListRepository;
import com.ednaldo.List.Games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<ListGameDTO> listGames() {
        List<GameList> list = gameListRepository.findAll();
        List<ListGameDTO> dto = list.stream().map(x -> new ListGameDTO(x)).toList();
        return dto;
    }
}

