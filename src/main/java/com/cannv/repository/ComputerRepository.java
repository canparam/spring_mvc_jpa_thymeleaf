package com.cannv.repository;

import com.cannv.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("computerRepository")
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
