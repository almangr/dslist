package br.dev.manga.dslist.services;

import br.dev.manga.dslist.dto.GameListDTO;
import br.dev.manga.dslist.entities.GameList;
import br.dev.manga.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(GameListDTO::new).toList();
  }
}
