package com.cannv.repository;

import com.cannv.model.Computer;
import com.cannv.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playersRepository")
public interface PlayersRepository extends JpaRepository<Players, Integer> {
    List<Players> findByplayerNameContains(String playerName);

}
