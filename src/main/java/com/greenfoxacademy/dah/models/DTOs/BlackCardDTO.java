package com.greenfoxacademy.dah.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlackCardDTO {
    private long id;
    private String text;
    private int bidCount;
    private int drawCount;
}
