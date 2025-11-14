package mate.academy.service.impl;

import mate.academy.dao.MovieDao;
import mate.academy.dao.impl.MovieDaoImpl;
import mate.academy.model.Movie;
import mate.academy.service.MovieService;
import mate.academy.util.HibernateUtil;

public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao = new MovieDaoImpl(HibernateUtil.getSessionFactory());

    @Override
    public Movie add(Movie movie) {
        movieDao.add(movie);
        return movie;
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow(()
                -> new RuntimeException("Movie not found in DB by following id: " + id));
    }
}
