package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entity.Address;
import peaksoft.entity.Programmer;
import peaksoft.exception.BadrequestException;
import peaksoft.repository.ProgrammerRepository;

import java.util.List;
import java.util.Optional;

public class ProgrammerRepositoryImpl implements ProgrammerRepository {
    private final EntityManager entityManager = HibernateConfiguration.getEntityManager();

    @Override
    public void saveProgrammer(Programmer programmer) {
        try {
            entityManager.getTransaction().begin();
        if (entityManager.contains(programmer.getEmail())){
            throw new BadrequestException();

        }else {
            entityManager.persist(programmer);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    } catch (BadrequestException e) {
            throw new RuntimeException(e);
        }}

        @Override
    public void saveProgrammers(List<Programmer> programmers) {
        entityManager.getTransaction().begin();
        entityManager.contains(programmers);
        entityManager.persist(programmers);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public List<Programmer> getAllProgrammers() {
        entityManager.getTransaction().begin();
        List<Programmer> programmers = entityManager.
                createQuery("select Programmer ",
                        Programmer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return programmers;
    }

    @Override
    public Optional<Programmer> findByProgrammerId(Long id) {
        entityManager.getTransaction().begin();
        Programmer id1 = entityManager.createQuery("select p from Programmer p where p.id=:id",
                Programmer.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return Optional.ofNullable(id1);
    }

    @Override
    public String deleteByProgrammerId(Long id) {
        entityManager.getTransaction().begin();
        Programmer programmer = entityManager.find(Programmer.class, id);
        entityManager.remove(programmer);
        entityManager.getTransaction().commit();
        entityManager.close();
        return programmer.getFullName() + " is deleted";
    }

    @Override
    public String deleteAllProgrammers() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Programmer ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return " all programmers is deleted";
    }

    @Override
    public Programmer updateProgrammer(Long id, Programmer programmer) {
        entityManager.getTransaction().begin();
        Programmer id1 = entityManager.createQuery("select p from Programmer p " +
                "where p.id=:id", Programmer.class).setParameter("id", id).getSingleResult();
        id1.setFullName(programmer.getFullName());
        id1.setEmail(programmer.getEmail());
        id1.setDateOfBirth(programmer.getDateOfBirth());
        id1.setStatus(programmer.getStatus());
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public List<Programmer> findProgrammersByCountry(String country) {
        entityManager.getTransaction().begin();
        //select * from programmers p join addresses a on p.address_id = a.id
        //join countries c on a.country_id = c.id where country='KG';
        List<Programmer> id = entityManager.createQuery("select p from Programmer p join Address a " +
                                "on p.address.id=a.id join Country c on a.country.id=c.id where c.country=:country",
                        Programmer.class).
                setParameter("country", country).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id;
    }

    @Override
    public Programmer getYoungProgrammer() {
        entityManager.getTransaction().begin();
        Programmer programmer = entityManager.createQuery("select min (current date -dateOfBirth),p from Programmer p ",
                Programmer.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return programmer;
    }

    @Override
    public Programmer getOldProgrammer() {
        entityManager.getTransaction().begin();
        Programmer programmer = entityManager.createQuery("select max (current date-dateOfBirth )," +
                "p from Programmer p", Programmer.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return programmer;
    }
}
