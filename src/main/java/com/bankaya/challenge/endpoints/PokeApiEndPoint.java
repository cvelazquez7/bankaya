package com.bankaya.challenge.endpoints;


import challenge.carlosvelazquez.pokeapi.*;
import com.bankaya.challenge.service.PokeApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Log4j2
@Endpoint
@RequiredArgsConstructor
public class PokeApiEndPoint {

    private static final String NAMESPACE_URI = "http://carlosvelazquez.challenge/pokeapi";

    private final PokeApiService pokeApiService;

    /**
     * Gets a list of pokemon abilities.
     * Abilities provide passive effects for Pokémon in battle or in the overworld.
     *
     * @param request pokemon name wrapper in {@link GetAbilitiesRequest} to get abilities.
     * @return list of pokemon abilities {@link Ability}
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilitiesRequest(@RequestPayload GetAbilitiesRequest request) {
        return pokeApiService.getAbilities(request);
    }

    /**
     * Gets pokemon's base experience.
     * The base experience gained for defeating this Pokémon.
     *
     * @param request pokemon name wrapper in {@link GetBaseExperienceRequest} to get base experience.
     * @return base experience {@link BigInteger}
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperienceRequest(@RequestPayload GetBaseExperienceRequest request) {
        return pokeApiService.getBaseExperience(request);
    }

    /**
     * Gets a list of pokemon items held.
     * A list of items this Pokémon may be holding when encountered.
     *
     * @param request pokemon name wrapper in {@link GetHeldItemsRequest} to get held items.
     * @return list of pokemon items held {@link Held}
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItemsRequest(@RequestPayload GetHeldItemsRequest request) {
        return pokeApiService.getHeldItems(request);
    }

    /**
     * Get pokemon id.
     * The identifier for this resource.
     *
     * @param request pokemon name wrapper in {@link GetIdRequest} to get id.
     * @return pokemon id {@link BigInteger}
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetIdRequest")
    @ResponsePayload
    public GetIdResponse getIdRequest(@RequestPayload GetIdRequest request) {
        return pokeApiService.getId(request);
    }

    /**
     * Get pokemon name.
     * The name for this resource.
     *
     * @param request pokemon name wrapper in {@link GetNameRequest} to get name.
     * @return pokemon name {@link String}
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetNameRequest")
    @ResponsePayload
    public GetNameResponse getNameRequest(@RequestPayload GetNameRequest request) {
        return pokeApiService.getName(request);
    }

    /**
     * Get pokemon link of location area encounter.
     * A link to a list of location areas, as well as encounter details pertaining to specific versions.
     *
     * @param request pokemon name wrapper in {@link GetLocationAreaEncountersRequest} to get location area encounters request.
     * @return link of location area encounter {@link String}
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncountersRequest(@RequestPayload GetLocationAreaEncountersRequest request) {
        return pokeApiService.getLocationAreaEncounters(request);
    }


}
