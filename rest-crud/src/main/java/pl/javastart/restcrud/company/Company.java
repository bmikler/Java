package pl.javastart.restcrud.company;

import pl.javastart.restcrud.joboffer.JobOffer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String city;
    private Integer employees;
    private String telephone;
    private String email;
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<JobOffer> jobOffers;

    public Company() {
    }

    public Company(Long id, String name, String description, String city, Integer employees, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
        this.employees = employees;
        this.telephone = telephone;
        this.email = email;
        this.jobOffers = jobOffers;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public Integer getEmployees() {
        return employees;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }
}
