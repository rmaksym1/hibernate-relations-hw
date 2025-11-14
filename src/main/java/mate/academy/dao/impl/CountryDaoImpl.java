package mate.academy.dao.impl;

import java.util.Optional;
import mate.academy.dao.CountryDao;
import mate.academy.model.Country;
import mate.academy.util.DataProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CountryDaoImpl extends AbstractDao implements CountryDao {
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Country add(Country country) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(country);
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
        return country;
    }

    @Override
    public Optional<Country> get(Long id) {
        Session session = null;
        try {
            session = factory.openSession();
            return Optional.ofNullable(session.find(Country.class, id));
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
