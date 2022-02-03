package pl.javastart.restcrud.joboffer;

import pl.javastart.restcrud.company.Company;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String requirements;
    private String duties;
    private String location;
    private Double minSalary;
    private Double maxSalary;
    private LocalDateTime dateAdded;
    private Integer submissions;
    @ManyToOne(optional = false)
    @JoinColumn(name = "companyId")
    private Company company;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getDuties() {
        return duties;
    }

    public String getLocation() {
        return location;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public Integer getSubmissions() {
        return submissions;
    }

    public Company getCompany() {
        return company;
    }
}
