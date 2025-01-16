package ma.ehtp.hospital.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ma.ehtp.hospital.entities.*;
import ma.ehtp.hospital.repositories.*;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
   
   HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
       this.patientRepository = patientRepository;
       this.medecinRepository = medecinRepository;
       this.rendezVousRepository = rendezVousRepository;
       this.consultationRepository = consultationRepository;
   }     


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

}
