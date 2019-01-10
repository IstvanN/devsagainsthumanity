package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
