package br.edu.ifsp.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.repository.StarshipRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StarshipService {

    private final StarshipRepository starshipRepository;

    public List<Starship> findAllStarships() {
        return starshipRepository.findAllStarships();
    }

    public Starship findStarshipById(Integer id) {
        return starshipRepository.findStarshipById(id);
    }

    public void saveStarship(Starship starship) {
        starshipRepository.saveStarship(starship);
    }

    public void updateStarship(Starship starship) {
        starshipRepository.updateStarship(starship);
    }

    public void deleteStarship(Integer id) {
        starshipRepository.deleteStarship(id);
    }
}
