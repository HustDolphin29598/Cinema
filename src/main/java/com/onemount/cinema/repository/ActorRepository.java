package com.onemount.cinema.repository;

import com.onemount.cinema.enums.Country;
import com.onemount.cinema.model.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepository {

    private ArrayList<Actor> actors;

    public ActorRepository(){
        actors = new ArrayList<>();
        actors.add(new Actor(1, "Robert Downey Jr", 40, Country.US));
    }

    public List<Actor> getAllActors(){
        return actors;
    }

    public Actor getActorById(int id) {
        return (Actor) actors.stream()
                .filter(actor -> actor.getId() == id)
                .findAny().orElse(null);
    }
}
