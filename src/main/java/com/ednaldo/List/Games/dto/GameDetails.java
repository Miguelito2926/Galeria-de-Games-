package com.ednaldo.List.Games.dto;

import com.ednaldo.List.Games.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@NoArgsConstructor
@Data
@ToString
public class GameDetails implements Serializable {
    private static final long serialVersion = 1L;

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDetails(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
