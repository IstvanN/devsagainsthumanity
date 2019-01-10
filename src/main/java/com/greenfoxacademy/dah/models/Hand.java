package com.greenfoxacademy.dah.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Hand {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private List<WhiteCard> cards;
}