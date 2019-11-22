package com.partoneheroes.services.services;

import com.partoneheroes.services.models.HeroCreateServiceModel;

public interface UsersService {
    void createHeroForUser(String username, HeroCreateServiceModel hero);
}