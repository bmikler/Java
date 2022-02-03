package pl.javastart.restcrud.joboffer;

import org.springframework.stereotype.Service;
import pl.javastart.restcrud.company.Company;
import pl.javastart.restcrud.company.CompanyRepository;

import java.util.Optional;

@Service
class JobOfferDtoMapper {
    private final CompanyRepository companyRepository;

    public JobOfferDtoMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public JobOfferDto map(JobOffer jobOffer){


        return new JobOfferDto(
                jobOffer.getId(),
                jobOffer.getTitle(),
                jobOffer.getDescription(),
                jobOffer.getRequirements(),
                jobOffer.getDuties(),
                jobOffer.getLocation(),
                jobOffer.getMinSalary(),
                jobOffer.getMaxSalary(),
                jobOffer.getDateAdded(),
                jobOffer.getSubmissions(),
                jobOffer.getCompany().getId(),
                jobOffer.getCompany().getName()
        );

    }

    public JobOffer map(JobOfferDto jobOfferDto) {



        return new JobOffer(
                jobOfferDto.getId(),
                jobOfferDto.getTitle(),
                jobOfferDto.getDescription(),
                jobOfferDto.getRequirements(),
                jobOfferDto.getDuties(),
                jobOfferDto.getLocation(),
                jobOfferDto.getMinSalary(),
                jobOfferDto.getMaxSalary(),
                companyRepository.findById(jobOfferDto.getCompanyId()).orElse(null)
        );

    }

}
