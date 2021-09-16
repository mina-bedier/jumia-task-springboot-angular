package com.jumia.exercise.repository;

import com.jumia.exercise.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {

    @Query(value = "select c.countryName from Country c")
    List<String> getAllCountries();

    Country findByCountryName(String countryName);

}
