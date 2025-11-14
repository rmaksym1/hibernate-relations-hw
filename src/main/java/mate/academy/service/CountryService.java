package mate.academy.service;

import mate.academy.model.Country;

public interface CountryService {
    Country add(Country country);

    Country get(Long id);
}
