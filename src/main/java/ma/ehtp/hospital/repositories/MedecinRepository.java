package ma.ehtp.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ehtp.hospital.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    
   Medecin findByNom(String nom);
   

}
