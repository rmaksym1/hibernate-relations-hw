package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.dao.impl.ActorDaoImpl;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.service.ActorService;
import mate.academy.hibernate.relations.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class ActorServiceImpl implements ActorService {
    private final ActorDao actorDao;

    public ActorServiceImpl(SessionFactory sessionFactory) {
        this.actorDao = new ActorDaoImpl(sessionFactory);
    }

    @Override
    public Actor add(Actor actor) {
        return actorDao.add(actor);
    }

    @Override
    public Actor get(Long id) {
        return actorDao.get(id).orElseThrow(()
                -> new RuntimeException("Actor not found in DB by following id: " + id));
    }
}
