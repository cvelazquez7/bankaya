package com.bankaya.challenge.service;


import challenge.carlosvelazquez.pokeapi.*;
import com.bankaya.challenge.mapper.PokeApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PokeApiServiceImpl implements PokeApiService {
    private final RestTemplate restTemplate;
    private final PokeApiMapper pokeApiMapper;
    private static final String POKE_API_BASE_PATH = "https://pokeapi.co/api/v2/pokemon";

    /**
     * Invoke original REST API
     *
     * @param pokemonName pokemon name that you want to consult
     * @return Pokemon instance
     */
    public Pokemon invokeApi(String pokemonName) {
        return restTemplate.getForObject(String.format("%s/%s", POKE_API_BASE_PATH, pokemonName), Pokemon.class);
    }

    @Override
    public GetAbilitiesResponse getAbilities(GetAbilitiesRequest request) {
        return pokeApiMapper.mapAbilities(invokeApi(request.getName()));
    }

    @Override
    public GetBaseExperienceResponse getBaseExperience(GetBaseExperienceRequest request) {
        return pokeApiMapper.mapBaseExperience(invokeApi(request.getName()));
    }

    @Override
    public GetHeldItemsResponse getHeldItems(GetHeldItemsRequest request) {
        return pokeApiMapper.mapHeldItems(invokeApi(request.getName()));
    }

    @Override
    public GetIdResponse getId(GetIdRequest request) {
        return pokeApiMapper.mapId(invokeApi(request.getName()));
    }

    @Override
    public GetNameResponse getName(GetNameRequest request) {
        return pokeApiMapper.mapName(invokeApi(request.getName()));
    }

    @Override
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(GetLocationAreaEncountersRequest request) {
        return pokeApiMapper.mapLocationAreaEncounters(invokeApi(request.getName()));
    }
}
