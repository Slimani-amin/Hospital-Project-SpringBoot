package ma.ehtp.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ehtp.hospital.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
