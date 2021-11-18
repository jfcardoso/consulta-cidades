package com.github.jfcardoso.citiesapi.countries;

import com.github.jfcardoso.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
