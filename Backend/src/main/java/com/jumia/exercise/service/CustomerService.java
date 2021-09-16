package com.jumia.exercise.service;

import com.jumia.exercise.dto.SearchResultDto;
import com.jumia.exercise.entities.Customer;

import java.util.List;

public interface CustomerService {
    public String validatePhoneNumber (String phoneNumber);
    public List<SearchResultDto> getAllCustomers();
    public List<SearchResultDto> searchCustomersByCountry(String countryName);
    public List<SearchResultDto> searchCustomersByStatus(String statusType);
    public List<Customer> getCustomersByCountryCode (String countryName);
    public List<SearchResultDto> searchCustomersByCountryStatus (String countryName , String statusType);

}
