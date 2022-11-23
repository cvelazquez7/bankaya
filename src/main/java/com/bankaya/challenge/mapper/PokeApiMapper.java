package com.bankaya.challenge.mapper;

import challenge.carlosvelazquez.pokeapi.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PokeApiMapper {


    GetPokemonResponse map(Pokemon pokemon);

    @Mapping(target = "pokemon.baseExperience", ignore = true)
    @Mapping(target = "pokemon.heldItems", ignore = true)
    @Mapping(target = "pokemon.id", ignore = true)
    @Mapping(target = "pokemon.name", ignore = true)
    @Mapping(target = "pokemon.locationAreaEncounters", ignore = true)
    GetAbilitiesResponse mapAbilities(Pokemon pokemon);

    @Mapping(target = "pokemon.abilities", ignore = true)
    @Mapping(target = "pokemon.heldItems", ignore = true)
    @Mapping(target = "pokemon.id", ignore = true)
    @Mapping(target = "pokemon.name", ignore = true)
    @Mapping(target = "pokemon.locationAreaEncounters", ignore = true)
    GetBaseExperienceResponse mapBaseExperience(Pokemon pokemon);

    @Mapping(target = "pokemon.abilities", ignore = true)
    @Mapping(target = "pokemon.baseExperience", ignore = true)
    @Mapping(target = "pokemon.id", ignore = true)
    @Mapping(target = "pokemon.name", ignore = true)
    @Mapping(target = "pokemon.locationAreaEncounters", ignore = true)
    GetHeldItemsResponse mapHeldItems(Pokemon pokemon);

    @Mapping(target = "pokemon.abilities", ignore = true)
    @Mapping(target = "pokemon.baseExperience", ignore = true)
    @Mapping(target = "pokemon.heldItems", ignore = true)
    @Mapping(target = "pokemon.name", ignore = true)
    @Mapping(target = "pokemon.locationAreaEncounters", ignore = true)
    GetIdResponse mapId(Pokemon pokemon);

    @Mapping(target = "pokemon.abilities", ignore = true)
    @Mapping(target = "pokemon.baseExperience", ignore = true)
    @Mapping(target = "pokemon.heldItems", ignore = true)
    @Mapping(target = "pokemon.id", ignore = true)
    @Mapping(target = "pokemon.locationAreaEncounters", ignore = true)
    GetNameResponse mapName(Pokemon pokemon);

    @Mapping(target = "pokemon.abilities", ignore = true)
    @Mapping(target = "pokemon.baseExperience", ignore = true)
    @Mapping(target = "pokemon.heldItems", ignore = true)
    @Mapping(target = "pokemon.id", ignore = true)
    @Mapping(target = "pokemon.name", ignore = true)
    GetLocationAreaEncountersResponse mapLocationAreaEncounters(Pokemon pokemon);

}
