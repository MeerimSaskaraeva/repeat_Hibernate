package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entity.Address;
import peaksoft.exception.BadrequestException;
import peaksoft.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

public class AddressRepositoryImpl implements AddressRepository {
    private final EntityManager entityManager = HibernateConfiguration.getEntityManager();

    @Override
    public void saveAddress(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAllAddresses(List<Address> addresses) {
        entityManager.getTransaction().begin();
        for (Address address : addresses) {
            entityManager.persist(address);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Address> getAllAddresses() {
        entityManager.getTransaction().begin();
        List<Address> address = entityManager.
                createQuery("select Address ", Address.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return address;
    }

    @Override
    public Optional<Address> findByAddressId(Long id) {
        entityManager.getTransaction().begin();
        Address id1 = entityManager.createQuery("select a from Address a where a.id=:id", Address.class).
                setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return Optional.ofNullable(id1);
    }

    @Override
    public String deleteByAddressId(Long id) {
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, id);
        entityManager.remove(address);
        entityManager.getTransaction().commit();
        entityManager.close();
        return address.getRegionName()+"id deleted...";
    }

    @Override
    public String deleteAllAddress() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Address ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "all addresses is deleted";
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        entityManager.getTransaction().begin();
        Address id1 = entityManager.createQuery("select a from Address a where a.id=:id", Address.class).
                setParameter("id", id).getSingleResult();
        id1.setRegionName(address.getRegionName());
        id1.setStreet(address.getStreet());
        id1.setHomeNumber(address.getHomeNumber());

        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }
}
