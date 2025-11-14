package mate.academy.dao.impl;

import java.util.Optional;
import mate.academy.dao.ActorDao;
import mate.academy.model.Actor;
import mate.academy.util.DataProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ActorDaoImpl extends AbstractDao implements ActorDao {
    public ActorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Actor add(Actor actor) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(actor);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save movie to DB!", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return actor;
    }

    @Override
    public Optional<Actor> get(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return Optional.ofNullable(session.find(Actor.class, id));
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
