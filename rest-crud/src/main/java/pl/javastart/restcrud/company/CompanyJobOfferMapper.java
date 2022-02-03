package pl.javastart.restcrud.company;

import org.springframework.stereotype.Service;
import pl.javastart.restcrud.joboffer.JobOffer;

@Service
class CompanyJobOfferMapper {

    public CompanyJobOfferDto map(JobOffer jobOffer){

        return new CompanyJobOfferDto(
                jobOffer.getId(),
                jobOffer.getTitle(),
                jobOffer.getMinSalary(),
                jobOffer.getMaxSalary(),
                jobOffer.getLocation()
        );

    }



}
