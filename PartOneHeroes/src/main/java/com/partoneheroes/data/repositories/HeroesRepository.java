package com.partoneheroes.data.repositories;

import com.partoneheroes.data.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroesRepository extends JpaRepository<Hero, Long> {
    Optional<Hero> getByNameIgnoreCase(String name);
}
