package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.Status;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "programmers")
@NoArgsConstructor
@ToString(exclude = "address")

public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;

    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(mappedBy = "programmers", cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
//    @JoinTable(name = "project_programmers",
//    joinColumns = @JoinColumn(name = "project_id"),
//    inverseJoinColumns = @JoinColumn(name = "programmer_id"))
    private List<Project> projects;
    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Address address;

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status, Address address) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.address = address;
    }
}
