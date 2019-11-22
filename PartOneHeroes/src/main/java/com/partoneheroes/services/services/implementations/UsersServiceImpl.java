package com.partoneheroes.services.services.implementations;

import com.partoneheroes.data.models.Hero;
import com.partoneheroes.data.models.User;
import com.partoneheroes.data.repositories.UsersRepository;
import com.partoneheroes.services.models.HeroCreateServiceModel;
import com.partoneheroes.services.services.HeroesService;
import com.partoneheroes.services.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    private final HeroesService heroesService;
    private final UsersRepository usersRepository;
    private final ModelMapper mapper;

    public UsersServiceImpl(HeroesService heroesService, UsersRepository usersRepository, ModelMapper mapper) {
        this.heroesService = heroesService;
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }

    @Override
    public void createHeroForUser(String username, HeroCreateServiceModel heroServiceModel) {
        User user = usersRepository.findByUsername(username);
        Hero hero = heroesService.create(heroServiceModel);
        user.setHero(hero);
        usersRepository.save(user);
    }
}
