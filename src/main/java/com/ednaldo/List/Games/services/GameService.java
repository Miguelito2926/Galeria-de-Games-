package com.ednaldo.List.Games.services;

import com.ednaldo.List.Games.dto.GameDetails;
import com.ednaldo.List.Games.entities.Game;
import com.ednaldo.List.Games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDetails> findAll() {
       List<Game> list = gameRepository.findAll();
       List<GameDetails> dto = list.stream().map(x -> new GameDetails(x)).toList();
       return dto;
    }
}
