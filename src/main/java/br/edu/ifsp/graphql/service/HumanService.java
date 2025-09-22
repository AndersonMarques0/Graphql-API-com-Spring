package br.edu.ifsp.graphql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.HumanRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;

    public List<Human> findAllHumans() {
        return humanRepository.findAllHumans();
    }

    public Human findHumanById(String id) {
        return humanRepository.findHumanById(id);
    }

    public void saveHuman(Human human) {
        humanRepository.saveHuman(human);
    }

    public void updateHuman(Human human) {
        humanRepository.updateHuman(human);
    }

    public void deleteHuman(String id) {
        humanRepository.deleteHuman(id);
    }
}
