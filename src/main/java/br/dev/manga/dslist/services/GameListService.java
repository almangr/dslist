package br.dev.manga.dslist.services;

import br.dev.manga.dslist.dto.GameListDTO;
import br.dev.manga.dslist.entities.GameList;
import br.dev.manga.dslist.projections.GameMinProjection;
import br.dev.manga.dslist.repositories.GameListRepository;
import br.dev.manga.dslist.repositories.GameRepository;
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
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(GameListDTO::new).toList();
  }

  @Transactional
  public void move(Long listId, int originIndex, int destinyIndex) {

    List<GameMinProjection> list = gameRepository.searchByList(listId);

    GameMinProjection obj = list.remove(originIndex);
    list.add(destinyIndex, obj);

    int min = Math.min(originIndex, destinyIndex);
    // int min = originIndex < destinyIndex ? originIndex : destinyIndex;
    int max = Math.max(originIndex, destinyIndex);
    // int max = originIndex < destinyIndex ? destinyIndex : originIndex;

    for (int i  = min; i <= max; i++) {
      gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
  }

}
