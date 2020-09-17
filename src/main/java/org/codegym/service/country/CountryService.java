package org.codegym.service.country;

import org.codegym.model.Country;
import org.codegym.service.IGenericService;

public interface CountryService extends IGenericService<Country> {
    Iterable<Country> findAllByOrderByName();
}
