package br.com.DeybsonFrancisco.resources;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.DeybsonFrancisco.domain.dto.patient.PatientDto;
import br.com.DeybsonFrancisco.domain.dto.patient.PatientPersistDto;
import br.com.DeybsonFrancisco.domain.entities.Patient;
import br.com.DeybsonFrancisco.event.CreatedResourceEvent;
import br.com.DeybsonFrancisco.service.impl.PatientServiceImpl;

@RestController
@RequestMapping(path= "/users/patients")
public class PatientResource {
	
	@Autowired
	private PatientServiceImpl service;

	@Autowired
	private ApplicationEventPublisher publicher;

	@GetMapping
	public ResponseEntity<Optional<Page<Patient>>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "lines", defaultValue = "10") Integer lines,
			@RequestParam(value = "dir", defaultValue = "ASC") String dir) {
				
		Pageable pagenation = PageRequest.of(page, lines, Direction.valueOf(dir), "name");
		Optional<Page<Patient>> list = service.list(pagenation);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Patient>> findById(@PathVariable Long id){
		Optional<Patient> patient = service.find(id);
		return patient.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(patient)
			: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping(path="/{name}")
	public ResponseEntity<Optional<Patient>> findById(@PathVariable String name){
		Optional<Patient> patient = service.findByName(name);
		return patient.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(patient)
			: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Optional<Patient>> create(@RequestBody PatientPersistDto dto, HttpServletResponse response){
		Optional<Patient> patient = service.save(Patient.getDomainFrom(dto));
		publicher.publishEvent(new CreatedResourceEvent(this, response, patient.get().getId(), "id"));
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
		
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Optional<Patient>> update(@PathVariable Long id, @RequestBody PatientDto dto){
		Optional<Patient> patientCurrent = service.update(id, Patient.getDomainFrom(dto));
	return ResponseEntity.status(HttpStatus.OK).body(patientCurrent);
		
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable Long id) {
		service.remove(id);
		ResponseEntity.status(HttpStatus.OK);
		
	}
	
}
