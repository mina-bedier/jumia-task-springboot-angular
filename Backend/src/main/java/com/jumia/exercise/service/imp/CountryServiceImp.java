package com.jumia.exercise.service.imp;

import com.jumia.exercise.repository.CountryRepository;
import com.jumia.exercise.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImp implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<String> getCountryNames(){
        return countryRepository.getAllCountries();
    }

}
