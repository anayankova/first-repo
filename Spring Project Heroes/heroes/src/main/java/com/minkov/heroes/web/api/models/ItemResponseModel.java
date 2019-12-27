package com.minkov.heroes.web.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.minkov.heroes.data.models.Slot;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseModel {
    private long id;
    private String name;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
    private Slot slot;
    private boolean isOwned;
}
