package br.dev.manga.dslist.services;

import br.dev.manga.dslist.dto.GameMinDTO;
import br.dev.manga.dslist.entities.Game;
import br.dev.manga.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(GameMinDTO::new).toList();
  }
}
