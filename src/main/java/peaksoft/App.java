package peaksoft;

import peaksoft.entity.Address;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;
import peaksoft.service.AddressService;
import peaksoft.service.CountryService;
import peaksoft.service.ProgrammerService;
import peaksoft.service.ProjectService;
import peaksoft.service.impl.AddressServiceImpl;
import peaksoft.service.impl.CountryServiceImpl;
import peaksoft.service.impl.ProgrammerServiceImpl;
import peaksoft.service.impl.ProjectServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AddressService addressService=new AddressServiceImpl();
        CountryService countryService=new CountryServiceImpl();
        ProgrammerService programmerService=new ProgrammerServiceImpl();
        ProjectService projectService=new ProjectServiceImpl();

//        countryService.saveCountry(new Country("USA","Mountainscountry"));

        List<Country>countries=new ArrayList<>();
        countries.add(new Country("Russia","Bear country"));
        countries.add(new Country("Korea","Horror movie land"));
        countries.add(new Country("Kyrgyzstan","Mountains country"));

//        System.out.println(countryService.saveCountries(countries));

//        countryService.getAllCountries().forEach(System.out::println);

//        System.out.println("Write id");
//        System.out.println(countryService.findByCountryId(new Scanner(System.in).nextLong()));

//        System.out.println(countryService.clearByCountryId(new Scanner(System.in).nextLong()));


//        System.out.println(countryService.deleteAllCountries());

//        System.out.println("Write id");
//        System.out.println(countryService.updateCountry(new Scanner(System.in).nextLong(), new Country("USA", "Many states country")));

//        System.out.println(countryService.findLongDescription());//??????????

//        System.out.println(countryService.getCountCountry("USA"));// ?????????

//        addressService.saveAddress(new Address("Chuy","Osmonova","G58",new Country("KG")));

        List<Address>addresses=new ArrayList<>();
        addresses.add(new Address("Talas","Manas","675"));
        addresses.add(new Address("Kemin","Sovetskaya","65",new Country("KG")));
        addresses.add(new Address("Narin","Kirova","1",new Country("KZ")));
//        addressService.saveAllAddresses(addresses);

//        System.out.println(addressService.findByAddressId(new Scanner(System.in).nextLong()));

//        System.out.println(addressService.deleteByAddressId(new Scanner(System.in).nextLong()));

//        System.out.println(addressService.deleteAllAddress());

//        System.out.println(addressService.updateAddress(new Scanner(System.in).nextLong(),
//                new Address("Osh", "Sulayman Too", "123B")));


        programmerService.saveProgrammer(new Programmer("Meerim Saskaraeva","saskaraeva@gmail.com",
                LocalDate.of(2000,03,21),Status.OWNER));

        List<Programmer>programmers=new ArrayList<>();
        programmers.add(new Programmer("Emir Emirov","emir@gmail.com",
                LocalDate.of(2001,02,22),Status.OWNER,
                new Address("Bishkek","Kulatova","29",new Country("KG","My country"))));
        programmers.add(new Programmer("Lira Kanaatova","lira@gmail.com",
                LocalDate.of(1984,07,07),Status.COLLABORATOR,
                new Address("Bishkek","Manasa","9",new Country("KZ","Your country"))));
//        programmerService.saveProgrammers(programmers);

//        System.out.println(programmerService.findByProgrammerId(new Scanner(System.in).nextLong()));

//        System.out.println(programmerService.findProgrammersByCountry("KG"));

    }
}
