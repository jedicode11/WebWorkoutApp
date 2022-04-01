package WebWorkout.project.dao.impl;

import WebWorkout.project.dao.PlayerRepository;
import WebWorkout.project.exception.NoneexistingEntityException;
import WebWorkout.project.model.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PlayerRepositoryMemoryImpl implements PlayerRepository {
    private Map<Long, Player> playerMap = new HashMap<>();


    @Override
    public Collection<Player> findAll() {
        return playerMap.values();
    }

    @Override
    public Player findById(Long id) {
        return playerMap.get(id);
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
        return old;
    }

    @Override
    public void deleteById(Long id) throws NoneexistingEntityException {

    }

    @Override
    public Player deleteById(Player id) throws NoneexistingEntityException {
        var old = playerMap.remove(id);
        if(old == null) {
            throw new NoneexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return deleteById(old);
    }

    @Override
    public long count() {
        return playerMap.size();
    }
}