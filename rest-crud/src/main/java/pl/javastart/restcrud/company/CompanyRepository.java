package pl.javastart.restcrud.company;

import org.springframework.data.jpa.repository.JpaRepository;

interface CompanyRepository extends JpaRepository<Company, Long> {
}
