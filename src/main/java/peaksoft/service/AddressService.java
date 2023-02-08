package peaksoft.service;

import peaksoft.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    void saveAddress(Address address);
    void saveAllAddresses(List<Address> addresses);
    List<Address> getAllAddresses();
    Optional<Address> findByAddressId(Long id);
    String deleteByAddressId(Long id);
    String deleteAllAddress();
    Address updateAddress(Long id,Address address);

}
