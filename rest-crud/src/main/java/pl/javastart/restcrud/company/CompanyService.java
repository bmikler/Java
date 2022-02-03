package pl.javastart.restcrud.company;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class CompanyService {

    private CompanyRepository companyRepository;
    private CompanyDtoMapper companyDtoMapper;
    private CompanyJobOfferMapper companyJobOfferMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyDtoMapper companyDtoMapper, CompanyJobOfferMapper companyJobOfferMapper) {
        this.companyRepository = companyRepository;
        this.companyDtoMapper = companyDtoMapper;
        this.companyJobOfferMapper = companyJobOfferMapper;
    }

    public Optional<CompanyDto> findCompanyById(Long id) {
        return companyRepository.findById(id).map(companyDtoMapper::map);
    }

    public List<CompanyJobOfferDto> findOffersByCompany(Long companyId) {

        return companyRepository.findById(companyId)
                .map(Company::getJobOffers)
                .orElse(Collections.emptyList())
                .stream()
                .map(companyJobOfferMapper::map)
                .toList();

    }

    public CompanyDto save(CompanyDto companyDto){
        Company company = companyDtoMapper.map(companyDto);
        Company companySave = companyRepository.save(company);
        return companyDtoMapper.map(companySave);
    }

}
