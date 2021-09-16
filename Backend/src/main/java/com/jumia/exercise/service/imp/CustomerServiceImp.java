package com.jumia.exercise.service.imp;

import com.jumia.exercise.constants.Constant;
import com.jumia.exercise.dto.SearchResultDto;
import com.jumia.exercise.entities.Country;
import com.jumia.exercise.entities.Customer;
import com.jumia.exercise.repository.CountryRepository;
import com.jumia.exercise.repository.CustomerRepository;
import com.jumia.exercise.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CountryRepository countryRepository;
    private String countryCode;

    @Override
    public String validatePhoneNumber (String phoneNumber){

        String countryName = Constant.countryCodeMap.get(phoneNumber.substring(1,4));
        Pattern pattern = Pattern.compile(Constant.countryRegexMap.get(countryName));
        Matcher matcher = pattern.matcher(phoneNumber);
        if( matcher.matches() == true) {
            return "Valid";
        }
        else return "Not valid";
    }

    public List<SearchResultDto>  getAllCustomers(){
        List<SearchResultDto> searchResultList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers){
            searchResultList.add
                    (SearchResultDto.builder()
                            .customerName(customer.getName())
                            .phoneNumber(customer.getPhone())
                            .country(Constant.countryCodeMap.get(customer.getPhone().substring(1,4)))
                            .countryCode(customer.getPhone().substring(1,4))
                            .phoneStatus(validatePhoneNumber(customer.getPhone()))
                            .build());
        }
        return searchResultList;
    }

    @Override
    public List<Customer> getCustomersByCountryCode (String countryName){
        Country country = countryRepository.findByCountryName(countryName);
        return customerRepository.getCustomerByCountryCode(country.getCountryCode());
    }


    @Override
    public List<SearchResultDto> searchCustomersByCountry(String countryName){
        List<SearchResultDto> searchResultList = new ArrayList<>();
        List<Customer> customers = getCustomersByCountryCode(countryName);
        for (Customer customer : customers){
            searchResultList.add(SearchResultDto.builder()
                    .customerName(customer.getName())
                    .phoneNumber(customer.getPhone())
                    .country(Constant.countryCodeMap.get(customer.getPhone().substring(1,4)))
                    .countryCode(countryCode)
                    .phoneStatus(validatePhoneNumber(customer.getPhone()))
                    .build());
        }
        return searchResultList;
    }

    @Override
    public List<SearchResultDto> searchCustomersByStatus(String statusType){
        List<SearchResultDto> searchResultList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers){
            if (validatePhoneNumber(customer.getPhone()).equals(statusType)) {
                searchResultList.add(SearchResultDto.builder()
                        .customerName(customer.getName())
                        .phoneNumber(customer.getPhone())
                        .country(Constant.countryCodeMap.get(customer.getPhone().substring(1,4)))
                        .countryCode(customer.getPhone().substring(1, 4))
                        .phoneStatus(validatePhoneNumber(customer.getPhone()))
                        .build());
            }
        }
       return searchResultList;
    }

    @Override
    public List<SearchResultDto> searchCustomersByCountryStatus(String countryName , String statusType){
        List<SearchResultDto> searchResultList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers){
            if (validatePhoneNumber(customer.getPhone()).equals(statusType)
                    && Constant.countryCodeMap.get(customer.getPhone().substring(1,4)).equals(countryName)){
                searchResultList.add(SearchResultDto.builder()
                        .customerName(customer.getName())
                        .country(countryName)
                        .phoneNumber(customer.getPhone())
                        .countryCode(customer.getPhone().substring(1,4))
                        .phoneStatus(statusType)
                        .build());
            }
        }
        return searchResultList;
    }


}
