package br.dev.manga.dslist.dto;

public class ReplacementDTO {

  private Integer originIndex;
  private Integer destinyIndex;

  public Integer getOriginIndex() {
    return originIndex;
  }

  public void setOriginIndex(Integer originIndex) {
    this.originIndex = originIndex;
  }

  public Integer getDestinyIndex() {
    return destinyIndex;
  }

  public void setDestinyIndex(Integer destinyIndex) {
    this.destinyIndex = destinyIndex;
  }
}
