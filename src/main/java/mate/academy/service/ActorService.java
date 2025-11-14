package mate.academy.service;

import mate.academy.model.Actor;

public interface ActorService {
    Actor add(Actor actor);

    Actor get(Long id);
}
