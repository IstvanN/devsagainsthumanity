package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findById(long id);

    List<Player> findAll();

    Player findFirstByName(String name);
}
