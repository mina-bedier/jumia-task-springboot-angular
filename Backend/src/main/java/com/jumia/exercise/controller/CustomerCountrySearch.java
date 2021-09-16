package com.jumia.exercise.controller;

import com.jumia.exercise.dto.CustomSearchDto;
import com.jumia.exercise.dto.SearchResultDto;
import com.jumia.exercise.service.CountryService;
import com.jumia.exercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jumia")
public class CustomerCountrySearch {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CountryService countryService;
    private List<String> countries;

    @GetMapping("country-names")
    public ResponseEntity<List<String>> getCountriesName (Model model){
       List<String> countries = countryService.getCountryNames();
       return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("customers")
    public ResponseEntity<List<SearchResultDto>> getAllCustomers (Model model){
        List<SearchResultDto> searchResultList = customerService.getAllCustomers();
        return new ResponseEntity<>(searchResultList, HttpStatus.OK);
    }


    @PostMapping("/search-customer")
    public ResponseEntity<List<SearchResultDto>> submitAction (@RequestBody CustomSearchDto customSearchDto){
        String countryName = customSearchDto.getCountryName();
        String phoneNumberstatus = customSearchDto.getStatus();
        List<SearchResultDto> searchResultList;
        /*
       trying to validate the request sent by the user
         */
        if (customSearchDto.getCountryName() != null && customSearchDto.getStatus() == null)
            searchResultList = customerService.searchCustomersByCountry(countryName);
        else if (customSearchDto.getCountryName() == null && customSearchDto.getStatus() != null)
            //search by status
            searchResultList = customerService.searchCustomersByStatus(phoneNumberstatus);
        else if (customSearchDto.getCountryName() != null && customSearchDto.getStatus() != null)
            //search by both options
            searchResultList = customerService.searchCustomersByCountryStatus(countryName,phoneNumberstatus);
        else //get all customers
            searchResultList = customerService.getAllCustomers();

        return new ResponseEntity<>(searchResultList, HttpStatus.OK);
    }
}
