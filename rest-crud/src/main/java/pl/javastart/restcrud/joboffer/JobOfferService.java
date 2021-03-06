package pl.javastart.restcrud.joboffer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobOfferService {

    private JobOfferRepository repository;
    private JobOfferDtoMapper dtoMapper;

    public JobOfferService(JobOfferRepository repository, JobOfferDtoMapper dtoMapper) {
        this.repository = repository;
        this.dtoMapper = dtoMapper;
    }

    List<JobOfferDto> findAll(){
        return repository.findAll()
                .stream()
                .map(dtoMapper::map)
                .collect(Collectors.toList());
    }

    Optional<JobOfferDto> findById(Long id){
        return repository.findById(id).map(dtoMapper::map);
    }

    JobOfferDto save(JobOfferDto jobOfferDto){
        JobOffer offer= dtoMapper.map(jobOfferDto);
        JobOffer offerSaved = repository.save(offer);

        return dtoMapper.map(offerSaved);
    }

    public void delete(Long id){

        repository.deleteById(id);

    }

}
