package com.greenfoxacademy.dah.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Lobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int generatedId;
    private String name;
    private boolean isStartable;

    @OneToMany
    private List<Player> playerList;

    public Lobby(String name) {
        this.generatedId = generateId();
        this.name = name;
        playerList = new ArrayList<>();
    }

    private Integer generateId() {
        Random rand = new Random();
        return rand.nextInt(10000);
    }
}