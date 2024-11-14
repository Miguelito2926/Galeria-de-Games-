package com.ednaldo.List.Games.services;

import com.ednaldo.List.Games.dto.GameSimpleDTO;
import com.ednaldo.List.Games.dto.ListGameDTO;
import com.ednaldo.List.Games.entities.GameList;
import com.ednaldo.List.Games.projections.GameSimpleProjection;
import com.ednaldo.List.Games.repositories.GameListRepository;
import com.ednaldo.List.Games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<ListGameDTO> listGames() {
        List<GameList> list = gameListRepository.findAll();
        List<ListGameDTO> dto = list.stream().map(x -> new ListGameDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public void move(Long id, int originIndex, int destinationIndex) {
        // Busca uma lista de objetos de projeção simples de jogos associada ao id especificado
        List<GameSimpleProjection> list = gameRepository.searchByList(id);

        // Remove o objeto da posição de origem na lista e o armazena em 'obj'
        GameSimpleProjection obj = list.remove(originIndex);

        // Insere o objeto na nova posição de destino na lista
        list.add(destinationIndex, obj);

        // Calcula os índices mínimo e máximo entre origem e destino
        // Isso permite iterar apenas nos elementos afetados pela mudança
        int min = Math.min(originIndex, destinationIndex);
        int max = Math.max(originIndex, destinationIndex);

        // Atualiza a posição de cada item no intervalo afetado (de min a max)
        for (int i = min; i <= max; i++) {
            // Atualiza a posição do item na base de dados usando o repositório de relacionamento entre lista e jogo
            gameListRepository.updateBelongingPosition(id, list.get(i).getId(), i);
        }
    }
}

