package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entity.Country;
import peaksoft.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

public class CountryRepositoryImpl implements CountryRepository {
    private final EntityManager entityManager = HibernateConfiguration.getEntityManager();

    @Override
    public String saveCountry(Country country) {
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return country.getCountry() + " is saved";
    }

    @Override
    public String saveCountries(List<Country> countries) {
        entityManager.getTransaction().begin();
        for (Country country : countries) {
            entityManager.persist(country);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return countries + " is saved";
    }

    @Override
    public List<Country> getAllCountries() {
        entityManager.getTransaction().begin();
        List<Country> countries = entityManager.
                createQuery("select c from Country c", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return countries;
    }

    @Override
    public Optional<Country> findByCountryId(Long countryId) {
        entityManager.getTransaction().begin();
        Country id = entityManager.createQuery("select c from Country c where c.id=:countryId",
                Country.class).setParameter("countryId", countryId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return Optional.ofNullable(id);
    }

    @Override
    public String clearByCountryId(Long countryId) {
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, countryId);
        entityManager.remove(country);
        entityManager.getTransaction().commit();
        entityManager.close();
        return country.getCountry() + " is deleted";
    }

    @Override
    public String deleteAllCountries() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Country ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "deleted all countries";
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        entityManager.getTransaction().begin();
        Country id1 = entityManager.createQuery("select c from Country c where c.id=:id",
                Country.class).setParameter("id", id).getSingleResult();
        id1.setCountry(country.getCountry());
        id1.setDescription(country.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public List<Country> findLongDescription() {
        entityManager.getTransaction().begin();
        List<Country> description1 = entityManager.createQuery("select  " +
                        "c from Country c where c.description=" +
                        "(select  max  (description) from Country c )",
                Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return description1;
    }

    @Override
    public int getCountCountry(String countryName) {
        entityManager.getTransaction().begin();
        int country = entityManager.createQuery("select count (country)  from " +
                "Country c where c.country=:countryName ").getFirstResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return country;
    }
}
