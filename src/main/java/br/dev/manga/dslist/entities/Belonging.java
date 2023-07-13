package br.dev.manga.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BELONGING")
public class Belonging {

  @EmbeddedId
  private BelongingPK id = new BelongingPK();

  private Integer position;

  public Belonging() {}

  public Belonging(Game game, GameList list, Integer position) {
    id.setGame(game);
    id.setList(list);
    this.position = position;
  }


}
