package peaksoft.repository;

import peaksoft.entity.Address;
import peaksoft.entity.Programmer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProgrammerRepository {
    void saveProgrammer(Programmer programmer);
    void saveProgrammers(List<Programmer>programmers);
    List<Programmer> getAllProgrammers();
    Optional<Programmer> findByProgrammerId(Long id);
    String deleteByProgrammerId(Long id);
    String deleteAllProgrammers();
    Programmer updateProgrammer(Long id,Programmer programmer);
    List<Programmer> findProgrammersByCountry(String country);
    Programmer getYoungProgrammer();
    Programmer getOldProgrammer();



}
