package br.com.DeybsonFrancisco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.DeybsonFrancisco.domain.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	Optional<Patient> findByName(String name);
}
