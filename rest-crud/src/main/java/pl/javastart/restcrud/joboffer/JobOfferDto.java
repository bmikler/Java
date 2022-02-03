package pl.javastart.restcrud.joboffer;

import java.time.LocalDateTime;

class JobOfferDto {

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
    private Long companyId;
    private String companyName;

    public JobOfferDto(Long id, String title, String description, String requirements, String duties, String location, Double minSalary, Double maxSalary, LocalDateTime dateAdded, Integer submissions, Long companyId, String companyName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.duties = duties;
        this.location = location;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.dateAdded = dateAdded;
        this.submissions = submissions;
        this.companyId = companyId;
        this.companyName = companyName;
    }

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

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }
}
