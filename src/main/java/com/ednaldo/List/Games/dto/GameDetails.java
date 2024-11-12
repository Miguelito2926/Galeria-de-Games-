package com.ednaldo.List.Games.dto;

import com.ednaldo.List.Games.entities.Game;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@ToString
public class GameDetails implements Serializable {
    private static final long serialVersion = 1L;
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDetails(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }
}
