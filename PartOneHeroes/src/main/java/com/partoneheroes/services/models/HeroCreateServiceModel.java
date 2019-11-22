package com.partoneheroes.services.models;

import com.partoneheroes.data.models.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroCreateServiceModel {
    private String name;
    private Gender gender;
}
