package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "programmers")
@EqualsAndHashCode
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    private String description;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;
    private int price;
    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(name = "project_programmers",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "programmer_id"))
    private List<Programmer>programmers;

}
