package peaksoft.service.impl;

import peaksoft.entity.Country;
import peaksoft.repository.CountryRepository;
import peaksoft.repository.impl.CountryRepositoryImpl;
import peaksoft.service.CountryService;

import java.util.List;
import java.util.Optional;

public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository=new CountryRepositoryImpl();
    @Override
    public String saveCountry(Country country) {
        return countryRepository.saveCountry(country);
    }

    @Override
    public String saveCountries(List<Country> countries) {
        return countryRepository.saveCountries(countries);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    @Override
    public Optional<Country> findByCountryId(Long countryId) {
        return countryRepository.findByCountryId(countryId);
    }

    @Override
    public String clearByCountryId(Long countryId) {
        return countryRepository.clearByCountryId(countryId);
    }

    @Override
    public String deleteAllCountries() {
        return countryRepository.deleteAllCountries();
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        return countryRepository.updateCountry(id,country);
    }

    @Override
    public List<Country> findLongDescription() {
        return countryRepository.findLongDescription();
    }

    @Override
    public int  getCountCountry(String countryName) {
        return countryRepository.getCountCountry(countryName);
    }
}
