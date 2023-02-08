package peaksoft.service.impl;

import peaksoft.entity.Project;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.impl.ProjectRepositoryImpl;
import peaksoft.service.ProjectService;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();

    @Override
    public void saveProject(Project project) {
        projectRepository.saveProject(project);
    }

    @Override
    public void saveProjects(List<Project> projects) {
        projectRepository.saveProjects(projects);

    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    @Override
    public Optional<Project> findByProjectId(Long id) {
        return projectRepository.findByProjectId(id);
    }

    @Override
    public String deleteByProjectId(Long id) {
        return projectRepository.deleteByProjectId(id);
    }

    @Override
    public String deleteAllProjectId() {
        return projectRepository.deleteAllProjectId();
    }

    @Override
    public Project updateProject(Long id, Project project) {
        return projectRepository.updateProject(id,project);
    }

    @Override
    public Project addProgrammerToProject(Long projectId, Long programmerId) {
        return projectRepository.addProgrammerToProject(projectId,programmerId);
    }

    @Override
    public Project getExpensiveProject() {
        return projectRepository.getExpensiveProject();
    }

    @Override
    public Project getProjectWrittenInShortTime() {
        return projectRepository.getProjectWrittenInShortTime();
    }
}
