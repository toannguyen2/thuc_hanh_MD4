package org.codegym.service.city;

import org.codegym.model.City;
import org.codegym.model.Country;
import org.codegym.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityServiceImpl(){}

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City entity) {
        cityRepository.save(entity);
        return entity;
    }

    @Override
    public boolean isExistsById(Long id) {
        return cityRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Iterable<City> findAllByOrderByName() {
        return cityRepository.findAllByOrderByName();
    }
}
