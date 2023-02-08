package peaksoft.service.impl;

import peaksoft.entity.Address;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.impl.AddressRepositoryImpl;
import peaksoft.service.AddressService;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository=new AddressRepositoryImpl();
    @Override
    public void saveAddress(Address address) {
        addressRepository.saveAddress(address);

    }

    @Override
    public void saveAllAddresses(List<Address> addresses) {
        addressRepository.saveAllAddresses(addresses);

    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public Optional<Address> findByAddressId(Long id) {
        return addressRepository.findByAddressId(id);
    }

    @Override
    public String deleteByAddressId(Long id) {
        return addressRepository.deleteByAddressId(id);
    }

    @Override
    public String deleteAllAddress() {
        return addressRepository.deleteAllAddress();
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        return addressRepository.updateAddress(id,address);
    }
}
