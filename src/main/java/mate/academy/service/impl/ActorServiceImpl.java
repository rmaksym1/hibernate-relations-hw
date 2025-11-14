package mate.academy.service.impl;

import mate.academy.dao.ActorDao;
import mate.academy.dao.impl.ActorDaoImpl;
import mate.academy.model.Actor;
import mate.academy.service.ActorService;
import mate.academy.util.HibernateUtil;

public class ActorServiceImpl implements ActorService {
    private final ActorDao actorDao = new ActorDaoImpl(HibernateUtil.getSessionFactory());

    @Override
    public Actor add(Actor actor) {
        actorDao.add(actor);
        return actor;
    }

    @Override
    public Actor get(Long id) {
        return actorDao.get(id).orElseThrow(()
                -> new RuntimeException("Actor not found in DB by following id: " + id));
    }
}
