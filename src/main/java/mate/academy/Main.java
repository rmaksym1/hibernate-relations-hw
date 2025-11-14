package mate.academy;

import java.util.List;
import mate.academy.model.Actor;
import mate.academy.model.Country;
import mate.academy.model.Movie;
import mate.academy.service.ActorService;
import mate.academy.service.CountryService;
import mate.academy.service.MovieService;
import mate.academy.service.impl.ActorServiceImpl;
import mate.academy.service.impl.CountryServiceImpl;
import mate.academy.service.impl.MovieServiceImpl;
import mate.academy.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        // use this session factory when you will initialize service instances
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Country usa = new Country("USA");
        CountryService countryService = new CountryServiceImpl();
        countryService.add(usa);

        Actor vinDiesel = new Actor("Vin Diesel");
        vinDiesel.setCountry(usa);
        ActorService actorService = new ActorServiceImpl();
        actorService.add(vinDiesel);

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setActors(List.of(vinDiesel));
        MovieService movieService = new MovieServiceImpl();
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
    }
}
