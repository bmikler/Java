package pl.javastart.restcrud.joboffer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class JobOfferService {

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

}
