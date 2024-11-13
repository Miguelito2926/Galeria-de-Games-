package com.ednaldo.List.Games.projections;

public interface GameSimpleProjection {

    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
