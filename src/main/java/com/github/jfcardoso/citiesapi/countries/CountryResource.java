package com.github.jfcardoso.citiesapi.countries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/countries")
public class CountryResource {

    private CountryRepository repository;

    public CountryResource(CountryRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCountry(@PathVariable Long id){
        /*
        se o id for válido retorna o país, senão retorna status 404
         */
        Optional<Country> country = repository.findById(id);
        if (country.isPresent()){
            return ResponseEntity.ok().body(country.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
