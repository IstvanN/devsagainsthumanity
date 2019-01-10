package com.greenfoxacademy.dah.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Lobby {
    private Integer id;
    private String name;
    private List<String> playerNameList;
    private boolean isStartable;

    public Lobby(String name, String creatorName) {
        this.id = generateId();
        this.name = name;
        playerNameList = new ArrayList<>();
        playerNameList.add(creatorName);
    }

    public Integer getId() {
        return this.id;
    }

    private Integer generateId() {
        Random rand = new Random();
        return rand.nextInt(10000);
    }
}