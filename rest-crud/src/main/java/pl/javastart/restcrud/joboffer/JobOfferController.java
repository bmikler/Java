package pl.javastart.restcrud.joboffer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
class JobOfferController {

    private JobOfferService service;

    public JobOfferController(JobOfferService service) {
        this.service = service;
    }

    @GetMapping
    List<JobOfferDto> getAllOffers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<JobOfferDto> getOfferById (@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
