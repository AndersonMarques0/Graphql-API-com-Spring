package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.graphql.model.Droid;

@Repository
public class DroidRepository {

    private final List<Droid> droids = new ArrayList<>();

    public List<Droid> findAllDroids() {
        return new ArrayList<>(droids);
    }

    public Droid findDroidById(String id) {
        return droids.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveDroid(Droid droid) {
        droids.add(droid);
    }

    public void updateDroid(Droid droid) {
        deleteDroid(droid.getId());
        saveDroid(droid);
    }

    public void deleteDroid(String id) {
        droids.removeIf(d -> d.getId().equals(id));
    }
}
