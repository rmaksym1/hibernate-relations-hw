package mate.academy.hibernate.relations.dao.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.util.DataProcessingException;
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
            throw new DataProcessingException("Can't save country to DB!", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return country;
    }

    @Override
    public Optional<Country> get(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.find(Country.class, id));
        } catch (RuntimeException e) {
            throw new DataProcessingException("Can't find Country with id: " + id, e);
        }
    }
}
