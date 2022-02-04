package pl.javastart.restcrud.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/company")
class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id){
        return companyService.findCompanyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("{companyId}/offers")
    public List<CompanyJobOfferDto> getOffersByCompany(@PathVariable Long companyId){

        return companyService.findOffersByCompany(companyId);

    }
    
    @PostMapping
    public ResponseEntity<CompanyDto> saveCompany(@RequestBody CompanyDto companyDto){

        CompanyDto company = companyService.save(companyDto);
        URI savedEntityLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand((company.getId()))
                .toUri();

        return ResponseEntity.created(savedEntityLocation).body(company);


    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> replaceCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto){

        return companyService.replace(id, companyDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();

    }

}
