package peaksoft.service;

import peaksoft.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    void saveProject(Project project);
    void saveProjects(List<Project> projects);
    List<Project> getAllProjects();
    Optional<Project> findByProjectId(Long id);
    String deleteByProjectId(Long id);
    String deleteAllProjectId();
    Project updateProject(Long id,Project project);
    Project addProgrammerToProject(Long projectId,Long programmerId);
    Project getExpensiveProject();
    Project getProjectWrittenInShortTime();
}
