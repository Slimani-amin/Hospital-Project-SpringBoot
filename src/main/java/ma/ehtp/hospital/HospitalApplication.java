package ma.ehtp.hospital;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ehtp.hospital.entities.*;
import ma.ehtp.hospital.repositories.*;
import ma.ehtp.hospital.service.HospitalServiceImpl;


@SpringBootApplication
public class HospitalApplication {


	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}	

	@Bean
	CommandLineRunner start(HospitalServiceImpl hospitalServiceImpl
	                     , PatientRepository patientRepository
	                     , MedecinRepository medecinRepository
						 , RendezVousRepository rendezVousRepository
						 , ConsultationRepository consultationRepository) {
		return args -> {
			Stream.of("Amine", "Mohamed", "Sara", "Fatima").forEach(nom -> {
				Patient patient = new Patient();
				patient.setNom(nom);
				patient.setDateNaissance(new Date());
				patient.setMalade(Math.random() > 0.5);
				hospitalServiceImpl.savePatient(patient);
			});
			Stream.of("Dr. Ali", "Dr. Fatima", "Dr. Youssef", "Dr. Salma").forEach(nom -> {
				Medecin medecin = new Medecin();
				medecin.setNom(nom);
				medecin.setSpecialite(Math.random()>0.5?"Cardiologue":"Dentiste");
				medecin.setEmail(nom.replaceAll(" ", "") + "@gmail.com");
				hospitalServiceImpl.saveMedecin(medecin);
			});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Medecin medecin = medecinRepository.findByNom("Dr. Ali");
			Patient patient2 = patientRepository.findByNom("Sara");
			System.out.println("Patient 1: " + patient.getNom());
			System.out.println("Medecin 1: " + medecin.getNom());
			System.out.println("Patient 2: " + patient2.getNom());

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			rendezVous.setStatus(StatusRDV.PENDING);
			hospitalServiceImpl.saveRDV(rendezVous);
			System.out.println("Rendez-vous créé avec succès");

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation.......");
			hospitalServiceImpl.saveConsultation(consultation);  








		};
	}

	
}
