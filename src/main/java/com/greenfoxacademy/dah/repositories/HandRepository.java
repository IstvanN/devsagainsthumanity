package com.greenfoxacademy.dah.repositories;

import com.greenfoxacademy.dah.models.Hand;
import org.springframework.data.repository.CrudRepository;

public interface HandRepository extends CrudRepository<Hand, Long> {

    Hand findById(long id);
}
