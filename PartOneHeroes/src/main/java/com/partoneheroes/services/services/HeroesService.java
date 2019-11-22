package com.partoneheroes.services.services;

import com.partoneheroes.data.models.Hero;
import com.partoneheroes.services.models.HeroCreateServiceModel;
import com.partoneheroes.services.models.HeroDetailsServiceModel;

public interface HeroesService {
    HeroDetailsServiceModel getByName(String name);

    Hero create(HeroCreateServiceModel serviceModel);
}
