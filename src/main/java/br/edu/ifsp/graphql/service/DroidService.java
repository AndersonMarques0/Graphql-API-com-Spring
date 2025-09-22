package br.edu.ifsp.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.repository.DroidRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DroidService {

    private final DroidRepository droidRepository;

    public List<Droid> findAllDroids() {
        return droidRepository.findAllDroids();
    }

    public Droid findDroidById(String id) {
        return droidRepository.findDroidById(id);
    }

    public void saveDroid(Droid droid) {
        droidRepository.saveDroid(droid);
    }

    public void updateDroid(Droid droid) {
        droidRepository.updateDroid(droid);
    }

    public void deleteDroid(String id) {
        droidRepository.deleteDroid(id);
    }
}
