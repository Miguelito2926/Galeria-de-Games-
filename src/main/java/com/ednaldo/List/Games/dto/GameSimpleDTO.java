package com.ednaldo.List.Games.dto;

import com.ednaldo.List.Games.entities.Game;
import com.ednaldo.List.Games.projections.GameSimpleProjection;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@ToString
public class GameSimpleDTO implements Serializable {
    private static final long serialVersion = 1L;
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameSimpleDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameSimpleDTO(GameSimpleProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }
}
