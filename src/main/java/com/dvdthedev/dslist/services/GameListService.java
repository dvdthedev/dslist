package com.dvdthedev.dslist.services;


import com.dvdthedev.dslist.dto.GameListDTO;
import com.dvdthedev.dslist.entities.GameList;
import com.dvdthedev.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class GameListService {
    @Autowired
    GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }


}
