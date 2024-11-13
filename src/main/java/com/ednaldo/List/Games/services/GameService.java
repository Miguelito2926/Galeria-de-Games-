package com.ednaldo.List.Games.services;

import com.ednaldo.List.Games.dto.GameDetails;
import com.ednaldo.List.Games.dto.GameSimpleDTO;
import com.ednaldo.List.Games.dto.ListGameDTO;
import com.ednaldo.List.Games.entities.Game;
import com.ednaldo.List.Games.entities.GameList;
import com.ednaldo.List.Games.projections.GameSimpleProjection;
import com.ednaldo.List.Games.repositories.GameListRepository;
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

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameSimpleDTO> findAllGames() {
        List<Game> list = gameRepository.findAll();
        List<GameSimpleDTO> dto = list.stream().map(x -> new GameSimpleDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDetails gameById(Long id) throws ResponseStatusException {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new GameDetails(game);
    }

    public List<GameSimpleDTO> findByGameList(Long id) {

        List<GameSimpleProjection> lisGamesProjections = gameRepository.searchByList(id);
        List<GameSimpleDTO> dtos = lisGamesProjections.stream().map(x -> new GameSimpleDTO(x)).toList();

        return dtos;
    }
}

