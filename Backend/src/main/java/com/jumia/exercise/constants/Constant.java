package com.jumia.exercise.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constant {

    public static final Map<String, String> countryCodeMap = initCountryCodeMap();
    public static final Map<String, String> countryRegexMap = initCountryRegexMap();

    private static final Map<String, String> initCountryCodeMap()
    {
        Map<String,String> countryCodeMap = new HashMap<>();
        countryCodeMap.put("237","Cameroon");
        countryCodeMap.put("251","Ethiopia");
        countryCodeMap.put("212","Morocco");
        countryCodeMap.put("258","Mozambique");
        countryCodeMap.put("256","Uganda");
        return Collections.unmodifiableMap(countryCodeMap);
    }

    private static final Map<String,String> initCountryRegexMap()
    {
        Map<String,String> countryRegexMap = new HashMap<>();
        countryRegexMap.put("Cameroon","\\(237\\)\\?[2368]\\d{7,8}$");
        countryRegexMap.put("Ethiopia","\\(251\\)\\ ?[1-59]\\d{8}$");
        countryRegexMap.put("Morocco","\\(212\\)\\ ?[5-9]\\d{8}$");
        countryRegexMap.put("Mozambique","\\(258\\)\\ ?[28]\\d{7,8}$");
        countryRegexMap.put("Uganda","256\\)\\ ?\\d{9}$");
        return Collections.unmodifiableMap(countryRegexMap);
    }
}
