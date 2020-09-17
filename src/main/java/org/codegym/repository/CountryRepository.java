package org.codegym.repository;

import org.codegym.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Iterable<Country> findAllByOrderByName();
}
