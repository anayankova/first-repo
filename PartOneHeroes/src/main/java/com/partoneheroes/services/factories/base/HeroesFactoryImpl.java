package com.partoneheroes.services.factories.base;

import com.partoneheroes.config.annotations.Factory;
import com.partoneheroes.data.models.Gender;
import com.partoneheroes.data.models.Hero;
import com.partoneheroes.services.factories.HeroesFactory;

@Factory
public class HeroesFactoryImpl implements HeroesFactory {
    @Override
    public Hero create(String name, Gender gender) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setAttack(1);
        hero.setDefence(1);
        hero.setLevel(1);
        hero.setStamina(1);
        hero.setStrength(1);
        return hero;
    }
}
