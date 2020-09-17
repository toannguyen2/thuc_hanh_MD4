package org.codegym.service.city;

import org.codegym.model.City;
import org.codegym.model.Country;
import org.codegym.service.IGenericService;

public interface CityService extends IGenericService<City> {
    Iterable<City> findAllByOrderByName();
}
