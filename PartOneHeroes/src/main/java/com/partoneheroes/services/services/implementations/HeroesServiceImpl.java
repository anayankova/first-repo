package com.partoneheroes.services.services.implementations;

import com.partoneheroes.data.models.Hero;
import com.partoneheroes.data.models.Item;
import com.partoneheroes.data.models.Slot;
import com.partoneheroes.data.repositories.HeroesRepository;
import com.partoneheroes.services.factories.HeroesFactory;
import com.partoneheroes.services.models.HeroCreateServiceModel;
import com.partoneheroes.services.models.HeroDetailsServiceModel;
import com.partoneheroes.services.models.HeroItemServiceModel;
import com.partoneheroes.services.services.HeroesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroesServiceImpl implements HeroesService {
    private final HeroesRepository heroesRepository;
    private final HeroesFactory heroesFactory;
    private final ModelMapper mapper;

    public HeroesServiceImpl(HeroesRepository heroesRepository, HeroesFactory heroesFactory, ModelMapper mapper) {
        this.heroesRepository = heroesRepository;
        this.heroesFactory = heroesFactory;
        this.mapper = mapper;
    }

    @Override
    public HeroDetailsServiceModel getByName(String name) {
        Optional<Hero> heroOptional = heroesRepository.getByNameIgnoreCase(name);
        if (heroOptional.isEmpty()) {
            throw new NullPointerException("No such hero");
        }

        Hero hero = heroOptional.get();

        HeroDetailsServiceModel serviceModel = mapper.map(hero, HeroDetailsServiceModel.class);

        serviceModel.setWeapon(getItemBySlot(hero.getItems(), Slot.WEAPON));
        serviceModel.setGauntlets(getItemBySlot(hero.getItems(), Slot.GAUNTLETS));
        serviceModel.setHelmet(getItemBySlot(hero.getItems(), Slot.HELMET));
        serviceModel.setPads(getItemBySlot(hero.getItems(), Slot.PADS));
        serviceModel.setPauldrons(getItemBySlot(hero.getItems(), Slot.PAULDRON));

        return serviceModel;
    }

    @Override
    public Hero create(HeroCreateServiceModel serviceModel) {
        Hero hero = heroesFactory.create(serviceModel.getName(), serviceModel.getGender());
        heroesRepository.save(hero);
        return hero;
    }

    private HeroItemServiceModel getItemBySlot(List<Item> items, Slot slot) {
        Optional<Item> item = items
                .stream()
                .filter(x -> x.getSlot() == slot)
                .findFirst();

        return item.isPresent()
                ? mapper.map(item, HeroItemServiceModel.class)
                : null;
    }
}
