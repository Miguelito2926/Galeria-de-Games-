package com.ednaldo.List.Games.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Data
@ToString
public class GamePositionDTO  {


    private Integer originIndex;
    private Integer destinationIndex;
}
