package com.partoneheroes.services.factories;

import com.partoneheroes.data.models.Gender;
import com.partoneheroes.data.models.Hero;

public interface HeroesFactory {
    Hero create(String name, Gender gender);
}
