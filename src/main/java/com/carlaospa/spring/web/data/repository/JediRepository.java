package com.carlaospa.spring.web.data.repository;

import java.util.List;

import com.carlaospa.spring.web.data.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

    List<Jedi> findByNameContainingIgnoreCase(final String name);
}
