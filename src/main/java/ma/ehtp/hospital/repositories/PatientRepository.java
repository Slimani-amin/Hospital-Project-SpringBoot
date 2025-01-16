package ma.ehtp.hospital.repositories;

import ma.ehtp.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByNom(String nom);
    



}
