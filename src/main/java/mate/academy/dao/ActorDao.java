package mate.academy.dao;

import java.util.Optional;
import mate.academy.model.Actor;

public interface ActorDao {
    Actor add(Actor actor);

    Optional<Actor> get(Long id);
}
