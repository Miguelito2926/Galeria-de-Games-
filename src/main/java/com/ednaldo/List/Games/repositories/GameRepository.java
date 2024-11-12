package com.ednaldo.List.Games.repositories;

import com.ednaldo.List.Games.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
