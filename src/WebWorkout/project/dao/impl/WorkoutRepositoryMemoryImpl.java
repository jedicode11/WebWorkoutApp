package WebWorkout.project.dao.impl;

import WebWorkout.project.dao.WorkoutRepository;
import WebWorkout.project.exception.NoneexistingEntityException;
import WebWorkout.project.model.Workout;

import java.util.*;

public class WorkoutRepositoryMemoryImpl implements WorkoutRepository {
    private Map<Long, Workout> workoutsByDate = new HashMap<>();


    @Override
    public Collection<Workout> findAll() {
        return workoutsByDate.values();
    }

    @Override
    public Workout findById(Long id) {
        return workoutsByDate.get(id);
    }

    @Override
    public Workout create(Workout entity) {
        entity.setId(entity.getId());
        workoutsByDate.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Workout update(Workout entity) throws NoneexistingEntityException {
        var old = findById(entity.getId());
        if(old == null) {
            throw new NoneexistingEntityException("Workout with ID='"
                    + entity.getId() + "' dose not exist.");
        }
        workoutsByDate.put(entity.getId(), entity);
        return old;
    }

    @Override
    public Workout deleteById(Long id) throws NoneexistingEntityException {
        var old = workoutsByDate.remove(id);
        if(old == null) {
            throw new NoneexistingEntityException("Workout with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        workoutsByDate.values().size();
        return 0;
    }
}
