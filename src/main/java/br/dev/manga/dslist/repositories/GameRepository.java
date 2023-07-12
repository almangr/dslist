package br.dev.manga.dslist.repositories;

import br.dev.manga.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
