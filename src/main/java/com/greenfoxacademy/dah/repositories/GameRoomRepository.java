package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.GameRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoomRepository extends CrudRepository<GameRoom, Long> {
    GameRoom getByGenereatedId(int generatedId);
}
