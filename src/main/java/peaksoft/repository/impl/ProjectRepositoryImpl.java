package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfiguration;
import peaksoft.entity.Project;
import peaksoft.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl implements ProjectRepository {
    private final EntityManager entityManager= HibernateConfiguration.getEntityManager();

    @Override
    public void saveProject(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void saveProjects(List<Project> projects) {
        entityManager.getTransaction().begin();
        for (Project project : projects) {
            entityManager.persist(project);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Project> getAllProjects() {
        entityManager.getTransaction().begin();
        List<Project> projects = entityManager.
                createQuery("select  Project ", Project.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return projects;
    }

    @Override
    public Optional<Project> findByProjectId(Long id) {
        entityManager.getTransaction().begin();
        Project id1 = entityManager.createQuery("select p from Project p where p.id=:id",
                Project.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return Optional.ofNullable(id1);
    }

    @Override
    public String deleteByProjectId(Long id) {
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, id);
        entityManager.remove(project);
        entityManager.getTransaction().commit();
        entityManager.close();
        return project.getProjectName()+" is deleted";
    }

    @Override
    public String deleteAllProjectId() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete Project ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "all projects is deleted";
    }

    @Override
    public Project updateProject(Long id, Project project) {
        entityManager.getTransaction().begin();
        Project id1 = entityManager.createQuery("select p from Project p " +
                        "where p.id=:id", Project.class).
                setParameter("id", id).getSingleResult();
        id1.setProjectName(project.getProjectName());
        id1.setDateOfStart(project.getDateOfStart());
        id1.setDateOfFinish(project.getDateOfFinish());
        id1.setPrice(project.getPrice());
        id1.setDescription(project.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public Project addProgrammerToProject(Long projectId, Long programmerId) {
        entityManager.getTransaction().begin();
        Project id = entityManager.createQuery("select pr from Project pr where pr.id=:projectId",
                Project.class).setParameter("id", projectId).getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();
        return id;
    }

    @Override
    public Project getExpensiveProject() {
        entityManager.getTransaction().begin();
        Project pr = entityManager.createQuery("select max (p.price)," +
                "p from Project p", Project.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return pr;
    }

    @Override
    public Project getProjectWrittenInShortTime() {
        entityManager.getTransaction().begin();
        Project pr = entityManager.createQuery("select min (p.dateOfFinish-p.dateOfStart)," +
                        "p from Project p", Project.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return pr;
    }
}
