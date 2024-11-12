package com.ednaldo.List.Games.dto;

import com.ednaldo.List.Games.entities.GameList;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
@Getter
@ToString
@NoArgsConstructor
public class ListGameDTO implements Serializable {
    private static final long serialVersion = 1L;

    private Long id;
    private String name;

    public ListGameDTO(GameList entity) {
        id = entity.getId();
        name = entity .getName();
    }
}
