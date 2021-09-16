package com.jumia.exercise.service;

import com.jumia.exercise.dto.SearchResultDto;
import com.jumia.exercise.entities.Customer;

import java.util.List;

public interface CountryService {
    public List<String> getCountryNames();
}
