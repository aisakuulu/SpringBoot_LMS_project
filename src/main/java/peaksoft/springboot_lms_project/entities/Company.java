package peaksoft.springboot_lms_project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "companies")
@Getter @Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_gen")
    @SequenceGenerator(name = "company_gen",
            sequenceName = "company_seq",
            allocationSize = 1)
    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany(mappedBy = "theCompany", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Course> courses;

    @OneToMany(mappedBy = "theCompany", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "theCompany", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    private Set<Student> students;

}
