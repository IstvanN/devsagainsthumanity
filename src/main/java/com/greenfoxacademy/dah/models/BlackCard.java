package com.greenfoxacademy.dah.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BlackCard {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private int bidCount;
    private int drawCount;
}
