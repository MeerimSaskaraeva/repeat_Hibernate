package peaksoft.service.impl;

import peaksoft.entity.Programmer;
import peaksoft.exception.BadrequestException;
import peaksoft.repository.ProgrammerRepository;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.impl.ProgrammerRepositoryImpl;
import peaksoft.service.ProgrammerService;

import java.util.List;
import java.util.Optional;

public class ProgrammerServiceImpl implements ProgrammerService {
    ProgrammerRepository programmerRepository = new ProgrammerRepositoryImpl();

    @Override
    public void saveProgrammer(Programmer programmer) {
        programmerRepository.saveProgrammer(programmer);
    }

        @Override
    public void saveProgrammers(List<Programmer> programmers) {
        programmerRepository.saveProgrammers(programmers);
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        return programmerRepository.getAllProgrammers();
    }

    @Override
    public Optional<Programmer> findByProgrammerId(Long id) {
        return programmerRepository.findByProgrammerId(id);
    }

    @Override
    public String deleteByProgrammerId(Long id) {
        return programmerRepository.deleteByProgrammerId(id);
    }

    @Override
    public String deleteAllProgrammers() {
        return programmerRepository.deleteAllProgrammers();
    }

    @Override
    public Programmer updateProgrammer(Long id, Programmer programmer) {
        return programmerRepository.updateProgrammer(id, programmer);
    }

    @Override
    public List<Programmer> findProgrammersByCountry(String country) {
        return programmerRepository.findProgrammersByCountry(country);
    }

    @Override
    public Programmer getYoungProgrammer() {
        return programmerRepository.getYoungProgrammer();
    }

    @Override
    public Programmer getOldProgrammer() {
        return programmerRepository.getOldProgrammer();
    }
}
