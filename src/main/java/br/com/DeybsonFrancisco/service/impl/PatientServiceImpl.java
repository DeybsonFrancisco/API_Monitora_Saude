package br.com.DeybsonFrancisco.service.impl;

import org.springframework.stereotype.Service;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.DeybsonFrancisco.domain.entities.Patient;
import br.com.DeybsonFrancisco.repository.PatientRepository;
import br.com.DeybsonFrancisco.service.ServiceInterface;

@Service
public class PatientServiceImpl implements ServiceInterface<Patient>{
	
	@Autowired
	private PatientRepository repository;

	@Override
	public Optional<Patient> save(Patient entity) {
		return Optional.of(repository.save(entity));
	}

	@Override
	public Optional<Patient> update(Long id, Patient entity) {
		Patient patientSave = findExistPatient(id);
		BeanUtils.copyProperties(entity, patientSave, "id", "password");
		return Optional.of(entity);
		
	}

	@Override
	public void remove(Long id) {
		Patient patientSave = findExistPatient(id);
			if(patientSave != null)
				repository.delete(patientSave);
		
	}

	@Override
	public Optional<Page<Patient>> list(Pageable page) {
		Page<Patient> list= repository.findAll(page);
		return Optional.of(list);
	}

	@Override
	public Optional<Patient> find(Long id) {
		Optional<Patient> patient = repository.findById(id);
		return patient;
	}
	
	public Optional<Patient> findByName(String name){
		Optional<Patient> patient = repository.findByName(name);
		return patient;
		
	}
	
	private Patient findExistPatient(Long id){
		Optional<Patient> patientSave = repository.findById(id);
		if (!patientSave.isPresent()) {
			throw new IllegalArgumentException();
		}
		return patientSave.get();
	}

	

}
