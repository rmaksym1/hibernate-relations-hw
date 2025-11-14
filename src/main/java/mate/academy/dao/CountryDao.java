package mate.academy.dao;

import java.util.Optional;
import mate.academy.model.Country;

public interface CountryDao {
    Country add(Country country);

    Optional<Country> get(Long id);
}
