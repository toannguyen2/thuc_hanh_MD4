package org.codegym.repository;

import org.codegym.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    Iterable<City> findAllByOrderByName();
}
