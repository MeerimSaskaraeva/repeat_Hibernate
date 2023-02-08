package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String description;

    public Country(String country, String description) {
        this.country = country;
        this.description = description;
    }

    public Country(String country) {
        this.country = country;
    }
}
