package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.graphql.model.Starship;

@Repository
public class StarshipRepository {

    private final List<Starship> starships = new ArrayList<>();

    public List<Starship> findAllStarships() {
        return new ArrayList<>(starships);
    }

    public Starship findStarshipById(Integer id) {
        return starships.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void saveStarship(Starship starship) {
        starships.add(starship);
    }

    public void updateStarship(Starship starship) {
        deleteStarship(starship.getId());
        saveStarship(starship);
    }

    public void deleteStarship(Integer id) {
        starships.removeIf(s -> s.getId() == id);
    }
}
