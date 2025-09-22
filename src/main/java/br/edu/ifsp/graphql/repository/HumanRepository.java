package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifsp.graphql.model.Human;

@Repository
public class HumanRepository {

    private final List<Human> humans = new ArrayList<>();

    public List<Human> findAllHumans() {
        return new ArrayList<>(humans);
    }

    public Human findHumanById(String id) {
        return humans.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void saveHuman(Human human) {
        humans.add(human);
    }

    public void updateHuman(Human human) {
        deleteHuman(human.getId());
        saveHuman(human);
    }

    public void deleteHuman(String id) {
        humans.removeIf(h -> h.getId().equals(id));
    }
}
