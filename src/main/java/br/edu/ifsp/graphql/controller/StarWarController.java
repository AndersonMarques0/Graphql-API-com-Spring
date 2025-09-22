package br.edu.ifsp.graphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.service.DroidService;
import br.edu.ifsp.graphql.service.HeroService;
import br.edu.ifsp.graphql.service.HumanService;
import br.edu.ifsp.graphql.service.ReviewService;
import br.edu.ifsp.graphql.service.SearchService;
import br.edu.ifsp.graphql.service.StarshipService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StarWarController {

    private final HeroService heroService;
    private final HumanService humanService;
    private final DroidService droidService;
    private final StarshipService starshipService;
    private final SearchService searchService;
    private final ReviewService reviewService;

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return heroService.getHero(episode);
    }

    @QueryMapping
    public List<Human> humans() {
        return humanService.findAllHumans();
    }

    @QueryMapping
    public Human human(@Argument String id) {
        return humanService.findHumanById(id);
    }

    @QueryMapping
    public List<Droid> droids() {
        return droidService.findAllDroids();
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return droidService.findDroidById(id);
    }

    @QueryMapping
    public List<Starship> starships() {
        return starshipService.findAllStarships();
    }

    @QueryMapping
    public Starship starship(@Argument Integer id) {
        return starshipService.findStarshipById(id);
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        return searchService.search(text);
    }

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return reviewService.createReview(episode, review);
    }

    @QueryMapping
    public Character character(@Argument String id) {
        
        Human human = humanService.findHumanById(id);
        if (human != null) {
            return human;
        }

        Droid droid = droidService.findDroidById(id);
        if (droid != null) {
            return droid;
        }

        return null;
    }

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Float height) {
        Human human = new Human(id, name, List.of(), List.of(), height);
        humanService.saveHuman(human);
        return human;
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        Droid droid = new Droid(id, name, List.of(), List.of(), primaryFunction);
        droidService.saveDroid(droid);
        return droid;
    }

    @MutationMapping
    public Starship createStarship(@Argument Integer id, @Argument String name, @Argument Float length) {
        Starship starship = new Starship(id, name, length);
        starshipService.saveStarship(starship);
        return starship;
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        
        Character character = humanService.findHumanById(characterId);
        if (character == null) {
            character = droidService.findDroidById(characterId);
        }

        
        Character friend = humanService.findHumanById(friendId);
        if (friend == null) {
            friend = droidService.findDroidById(friendId);
        }

        
        if (character != null && friend != null) {
            character.getFriends().add(friend);
        }

        return character;
    }

}
