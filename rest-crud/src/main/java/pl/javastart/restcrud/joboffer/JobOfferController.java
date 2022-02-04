package pl.javastart.restcrud.joboffer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    ResponseEntity<JobOfferDto> save(@RequestBody JobOfferDto jobOfferDto){

        JobOfferDto offer = service.save(jobOfferDto);

        URI savedEntityLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(offer.getId())
                .toUri();

        return ResponseEntity.created(savedEntityLocation).body(offer);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOffer(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
