package br.edu.ifsp.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Starship;

@Service
public class SearchService {

    public List<Object> search(String text) {
        return List.of(
                new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
                new Human("1001", "Luke", List.of(), List.of(), 1.72f),
                new Starship(3000, "Millenium Falcon", 1000)
        );
    }
}
