package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="addresses")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="region_name")
    private String regionName;
    private String street;
    @Column(name = "home_number")
    private String homeNumber;
    @OneToOne(mappedBy = "address",cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Programmer programmer;
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Country country;

    public Address(String regionName, String street, String homeNumber) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;

    }

    public Address(String regionName, String street, String homeNumber, Country country) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;
        this.country = country;
    }
}
