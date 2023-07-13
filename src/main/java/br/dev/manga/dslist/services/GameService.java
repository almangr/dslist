package br.dev.manga.dslist.services;

import br.dev.manga.dslist.dto.GameDTO;
import br.dev.manga.dslist.dto.GameMinDTO;
import br.dev.manga.dslist.entities.Game;
import br.dev.manga.dslist.projections.GameMinProjection;
import br.dev.manga.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public GameDTO findById(long id) {
    Game result = gameRepository.findById(id).get();
    return new GameDTO(result);
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> result = gameRepository.findAll();
    return result.stream().map(GameMinDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findByList(Long listid) {
    List<GameMinProjection> result = gameRepository.searchByList(listid);
    return result.stream().map(GameMinDTO::new).toList();
  }
}
