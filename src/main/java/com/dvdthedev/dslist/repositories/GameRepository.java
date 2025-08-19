package com.dvdthedev.dslist.repositories;

import com.dvdthedev.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
