package com.bankaya.challenge.service;


import challenge.carlosvelazquez.pokeapi.*;

public interface PokeApiService {

    /**
     * Get abilities of pokemon
     *
     * @param request pokemon name
     * @return list of abilities
     */
    GetAbilitiesResponse getAbilities(GetAbilitiesRequest request);

    /**
     * Get base experience of pokemon
     *
     * @param request pokemon name
     * @return base experience
     */
    GetBaseExperienceResponse getBaseExperience(GetBaseExperienceRequest request);

    /**
     * Get held items of pokemon
     *
     * @param request pokemon name
     * @return list of items held
     */
    GetHeldItemsResponse getHeldItems(GetHeldItemsRequest request);

    /**
     * Get id of pokemon
     *
     * @param request pokemon name
     * @return pokemon id
     */
    GetIdResponse getId(GetIdRequest request);

    /**
     * Get name of pokemon
     *
     * @param request pokemon name
     * @return pokemon name
     */
    GetNameResponse getName(GetNameRequest request);

    /**
     * Get location area encounters of pokemon
     *
     * @param request pokemon name
     * @return location area encounters link
     */
    GetLocationAreaEncountersResponse getLocationAreaEncounters(GetLocationAreaEncountersRequest request);

}