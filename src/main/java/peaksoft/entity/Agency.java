package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen", sequenceName = "agency_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private String phoneNumber;
    private String email;
    @Column(length = 10000000)
    private String image;
    @OneToMany(cascade = {ALL}, mappedBy = "agency")
    private List<House> houses;
    @ManyToMany(mappedBy = "agencies", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Customer> customers;

    public Agency(String name, String country, String phoneNumber, String email) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void addHouse(House house) {
        houses.add(house);
    }
}
