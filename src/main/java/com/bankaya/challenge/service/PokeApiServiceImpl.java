package com.bankaya.challenge.service;


import challenge.carlosvelazquez.pokeapi.*;
import com.bankaya.challenge.domain.RequestEntity;
import com.bankaya.challenge.event.SaveRequestEvent;
import com.bankaya.challenge.exception.CustomException;
import com.bankaya.challenge.mapper.PokeApiMapper;
import com.bankaya.challenge.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
@RequiredArgsConstructor
public class PokeApiServiceImpl implements PokeApiService {
    private final RestTemplate restTemplate;
    private final PokeApiMapper pokeApiMapper;
    private final RequestRepository requestRepository;

    @Value("${pokeapi.base-path}")
    private String pokeApiBasePath;

    /**
     * Invoke original REST API
     *
     * @param pokemonName pokemon name that you want to consult
     * @return Pokemon instance
     */
    public Pokemon invokeApi(String pokemonName) {
        try {
            return restTemplate.getForObject(String.format("%s/%s", pokeApiBasePath, pokemonName), Pokemon.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().is4xxClientError()) {
                log.error("Pokemon: {} not found", pokemonName);
                throw new CustomException("4XX", "Pokemon %s not found", e.getStatusCode(), pokemonName);
            } else {
                throw new CustomException(e.getStatusText(), "Http client generic error: %s", e.getStatusCode(), e.getMessage());
            }
        } catch (Exception e) {
            log.error("Unexpected error: {}", e.getMessage());
            throw new CustomException("XXX", "Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    /**
     * Persists the request
     *
     * @param event generated event
     */
    @EventListener
    public void saveRequestHandler(SaveRequestEvent event) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setMethod(event.getMethod());
        requestEntity.setIpAddress(event.getIpAddress());
        requestRepository.save(requestEntity);
    }

}
