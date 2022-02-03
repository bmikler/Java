package pl.javastart.restcrud.joboffer;

import org.springframework.stereotype.Service;

@Service
class JobOfferDtoMapper {
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
}
