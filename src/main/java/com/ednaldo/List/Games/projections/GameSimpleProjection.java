package com.ednaldo.List.Games.projections;

public interface GameSimpleProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
