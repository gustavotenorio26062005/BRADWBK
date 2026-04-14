package br.edu.ifsp.graphql.controller;

import br.edu.ifsp.graphql.model.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller // [cite: 667]
public class StarWarController {

    // --- QUERIES EXISTENTES ---

    @QueryMapping // [cite: 668]
    public Character hero(@Argument Episode episode) {
        return new Human("2001", "Luke Skywalker", List.of(Episode.NEWHOPE), List.of(), 1.75f);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return new Droid(id, "R2-D2", List.of(Episode.NEWHOPE), List.of(), "Astromech");
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        return List.of(
            new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
            new Human("1001", "Luke Skywalker", List.of(), List.of(), 1.75f),
            new Starship(3000, "Millenium Falcon", 1000f)
        );
    }

    // --- EXERCÍCIOS: NOVAS QUERIES [cite: 1143] ---

    @QueryMapping
    public List<Human> humans() {
        return List.of(new Human("1001", "Luke Skywalker", List.of(), List.of(), 1.75f));
    }

    @QueryMapping
    public List<Starship> starships() {
        return List.of(new Starship(3000, "Millenium Falcon", 1000f));
    }

    @QueryMapping
    public Character character(@Argument String id) {
        // Retorna um Character genérico (interface) que o Spring resolve para Human [cite: 590]
        return new Human(id, "Character Name", List.of(), List.of(), 1.80f);
    }

    // --- MUTATIONS [cite: 670] ---

    @MutationMapping // [cite: 670, 793]
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }

    // --- EXERCÍCIOS: NOVAS MUTATIONS [cite: 1148] ---

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Float height) {
        return new Human(id, name, List.of(), List.of(), height);
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        return new Droid(id, name, List.of(), List.of(), primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument Integer id, @Argument String name, @Argument Float length) {
        return new Starship(id, name, length);
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        // Simulação de retorno de um personagem com o novo vínculo [cite: 1159]
        return new Human(characterId, "Updated Character", List.of(), List.of(), 1.70f);
    }
}
