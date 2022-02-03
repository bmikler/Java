package pl.javastart.restcrud.joboffer;

import org.springframework.data.jpa.repository.JpaRepository;

interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
