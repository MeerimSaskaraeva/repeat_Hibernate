package peaksoft.repository;

import peaksoft.entity.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    String saveCountry(Country country);
    String saveCountries(List<Country>countries);
    List<Country> getAllCountries();
    Optional<Country>findByCountryId(Long countryId);
    String clearByCountryId(Long countryId);
    String deleteAllCountries();
    Country updateCountry(Long id,Country country);
    List<Country> findLongDescription();
    int getCountCountry(String countryName);



}
