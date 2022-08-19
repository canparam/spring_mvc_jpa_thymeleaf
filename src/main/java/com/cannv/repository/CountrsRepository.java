package com.cannv.repository;

import com.cannv.model.Countrs;
import com.cannv.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountrsRepository extends JpaRepository<Countrs, Integer> {
    @Query("Select c from Countrs c where c.continent like %?1%")
    List<Countrs> getQuery(String continent);
}
