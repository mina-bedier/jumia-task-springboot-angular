package com.jumia.exercise;

import com.jumia.exercise.dto.SearchResultDto;
import com.jumia.exercise.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CustomerSearchTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void isValidPhoneNumber()  {
        String status = customerService.validatePhoneNumber("(212) 698054317");
        assertEquals("Valid",status);
    }

    @Test
    public void isNotValidPhoneNumber() {
        String status = customerService.validatePhoneNumber("(212) 69805431712");
        assertThat(status).isEqualTo("Not valid");
    }

    @Test
    public void searchByCountryStatus()
    {
        assertThat(customerService.searchCustomersByCountryStatus("Cameroon","Valid")).isEmpty();
    }

//    @Test
//    public void searchCustomersByCountryandStatus()  {
//        List<SearchResultDto> resultSet = customerService.searchCustomersByCountryStatus("Ethiopia","Not Valid");
//        assertEquals(resultSet.stream().count(),2);
//    }



}
