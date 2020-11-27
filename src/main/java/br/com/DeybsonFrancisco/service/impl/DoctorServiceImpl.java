package br.com.DeybsonFrancisco.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.DeybsonFrancisco.domain.entities.Doctor;
import br.com.DeybsonFrancisco.repository.DoctorRepository;
import br.com.DeybsonFrancisco.service.ServiceInterface;

@Service
public class DoctorServiceImpl implements ServiceInterface<Doctor>{
	
    @Autowired
	private DoctorRepository repository;
	
	
	@Override
	public Optional<Doctor> save(Doctor entity) {
		return Optional.of(repository.save(entity));
	}

	@Override
	public Optional<Doctor> update(Long id, Doctor entity) {
		Doctor doctorSave = findExistDoctor(id);
		BeanUtils.copyProperties(entity, doctorSave, "id", "password");
		return Optional.of(entity);
		
	}

	@Override
	public void remove(Long id) {
		Doctor doctorSave = findExistDoctor(id);
			if(doctorSave != null)
				repository.delete(doctorSave);
		
	}

	@Override
	public Optional<Page<Doctor>> list(Pageable page) {
		Page<Doctor> list= repository.findAll(page);
		return Optional.of(list);
	}

	@Override
	public Optional<Doctor> find(Long id) {
		Optional<Doctor> doctor = repository.findById(id);
		return doctor;
	}
	
	
	private Doctor findExistDoctor(Long id){
		Optional<Doctor> doctorSave = repository.findById(id);
		if (!doctorSave.isPresent()) {
			throw new IllegalArgumentException();
		}
		return doctorSave.get();
	}	
}
