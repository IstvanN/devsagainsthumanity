package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.Lobby;
import org.springframework.data.repository.CrudRepository;

public interface LobbyRepository extends CrudRepository<Lobby, Long> {

  Lobby getByGeneratedId(int generatedId);
}
