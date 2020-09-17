package org.codegym.service.country;

import org.codegym.model.Country;
import org.codegym.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryServiceImpl(){}

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country entity) {
        return countryRepository.save(entity);
    }

    @Override
    public boolean isExistsById(Long id) {
        return countryRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Iterable<Country> findAllByOrderByName() {
        return countryRepository.findAllByOrderByName();
    }
}
