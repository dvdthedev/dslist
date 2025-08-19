package com.dvdthedev.dslist.services;

import com.dvdthedev.dslist.dto.GameMinDTO;
import com.dvdthedev.dslist.entities.Game;
import com.dvdthedev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> gameMinDTOS = result.stream().map(x -> new GameMinDTO(x)).toList();
        return gameMinDTOS;
    }

}
