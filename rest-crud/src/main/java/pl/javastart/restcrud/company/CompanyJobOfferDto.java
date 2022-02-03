package pl.javastart.restcrud.company;


class CompanyJobOfferDto {

    private Long id;
    private String title;
    private Double minSalary;
    private Double maxSalary;
    private String location;

    public CompanyJobOfferDto(Long id, String title, Double minSalary, Double maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public String getLocation() {
        return location;
    }
}
