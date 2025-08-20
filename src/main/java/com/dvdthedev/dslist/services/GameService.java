package com.dvdthedev.dslist.services;

import com.dvdthedev.dslist.dto.GameDTO;
import com.dvdthedev.dslist.dto.GameMinDTO;
import com.dvdthedev.dslist.entities.Game;
import com.dvdthedev.dslist.projections.GameMinProjection;
import com.dvdthedev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> gameMinDTOS = result.stream().map(x -> new GameMinDTO(x)).toList();
        return gameMinDTOS;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){

        Game result = gameRepository.findById(gameId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId).stream().toList();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
