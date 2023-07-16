package br.dev.manga.dslist.controller;

import br.dev.manga.dslist.dto.GameDTO;
import br.dev.manga.dslist.dto.GameMinDTO;
import br.dev.manga.dslist.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping(value = "/{id}")
  public GameDTO findById(@PathVariable Long id) {
    return gameService.findById(id);
  }
  @GetMapping
  public List<GameMinDTO> findAll() {
    return gameService.findAll();
  }
}
