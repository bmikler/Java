package pl.javastart.restcrud.company;

import org.springframework.stereotype.Service;

@Service
class CompanyDtoMapper {

    public CompanyDto map(Company company){
        return new CompanyDto(
                company.getId(),
                company.getName(),
                company.getDescription(),
                company.getCity(),
                company.getEmployees(),
                company.getTelephone(),
                company.getEmail()
        );
    }

    public Company map(CompanyDto companyDto){

        return new Company(
                companyDto.getId(),
                companyDto.getName(),
                companyDto.getDescription(),
                companyDto.getCity(),
                companyDto.getEmployees(),
                companyDto.getTelephone(),
                companyDto.getEmail()
        );

    }

}
