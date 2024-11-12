package com.ednaldo.List.Games.services;

import com.ednaldo.List.Games.dto.GameDetails;
import com.ednaldo.List.Games.dto.GameSimpleDTO;
import com.ednaldo.List.Games.entities.Game;
import com.ednaldo.List.Games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameSimpleDTO> findAll() {
       List<Game> list = gameRepository.findAll();
       List<GameSimpleDTO> dto = list.stream().map(x -> new GameSimpleDTO(x)).toList();
       return dto;
    }

    @Transactional(readOnly = true)
    public GameDetails gameById(Long id) throws Exception{
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new GameDetails(game);
    }
}
