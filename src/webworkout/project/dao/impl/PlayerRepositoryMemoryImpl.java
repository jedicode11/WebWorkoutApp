package webworkout.project.dao.impl;

import webworkout.project.dao.PlayerRepository;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Player;

import java.util.*;

public class PlayerRepositoryMemoryImpl implements PlayerRepository {
    private Map<Long, Player> playerMap = new HashMap<>();
    private NavigableMap<Integer, List<Player>> findPlayersById = new TreeMap<>();

    @Override
    public Collection<Player> findAll() {
        return playerMap.values();
    }

    @Override
    public Player findById(Long id) {
        return playerMap.get(id);
    }

    @Override
    public List<Player> findPlayersById(boolean ascending) {
        var valuesMap =  findPlayersById;
        if(!ascending) {
            valuesMap = valuesMap.descendingMap();
        }
        System.out.println("Player.findAllSorted() called.");
        List<Player> results = new ArrayList<>();
        for(List<Player> findPlayersById: valuesMap.values()){
            results.addAll(findPlayersById);
        }
        return results;
    }

    @Override
    public Player create(Player entity) {
        entity.setId(entity.getId());
        playerMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Player update(Player entity) throws NoneexistingEntityException {
        var old = findById(entity.getId());
        if(old == null) {
            throw new NoneexistingEntityException("Player with ID='"
                    + entity.getId() + "' dose not exist.");
        }
        playerMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Player deleteById(Long id) throws NoneexistingEntityException {
        var old = playerMap.remove(id);
        if(old == null) {
            throw new NoneexistingEntityException("Workout with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return playerMap.size();
    }
}