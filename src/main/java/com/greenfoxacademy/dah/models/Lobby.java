package com.greenfoxacademy.dah.models;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Lobby {
    private String id;
    private String name;
    private List<String> playerNameList;
    private boolean isStartable;

    public Lobby(String name, String creatorName) {
        this.id = generateId();
        this.name = name;
        playerNameList.add(creatorName);
    }

    private String generateId() {
        Random rand = new Random();
        byte[] array = new byte[4];
        rand.nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}