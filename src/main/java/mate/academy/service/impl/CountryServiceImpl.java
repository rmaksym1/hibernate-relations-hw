package mate.academy.service.impl;

import mate.academy.dao.CountryDao;
import mate.academy.dao.impl.CountryDaoImpl;
import mate.academy.model.Country;
import mate.academy.service.CountryService;
import mate.academy.util.HibernateUtil;

public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao = new CountryDaoImpl(HibernateUtil.getSessionFactory());

    @Override
    public Country add(Country country) {
        countryDao.add(country);
        return country;
    }

    @Override
    public Country get(Long id) {
        return countryDao.get(id).orElseThrow(()
                -> new RuntimeException("Country not found in DB by following id: " + id));
    }
}
