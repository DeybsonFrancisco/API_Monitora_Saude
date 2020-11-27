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

import br.com.DeybsonFrancisco.domain.dto.doctor.DoctorDto;
import br.com.DeybsonFrancisco.domain.dto.doctor.DoctorPersistDto;
import br.com.DeybsonFrancisco.domain.entities.Doctor;
import br.com.DeybsonFrancisco.event.CreatedResourceEvent;
import br.com.DeybsonFrancisco.service.impl.DoctorServiceImpl;

@RestController
@RequestMapping(path = "/users/doctors")
public class DoctorResource {

	@Autowired
	private DoctorServiceImpl service;
	
	@Autowired
	private ApplicationEventPublisher publicher;

	@GetMapping
	public ResponseEntity<Optional<Page<Doctor>>> findAll(@RequestParam(value= "page", defaultValue = "0") int page,
			@RequestParam(value="lines", defaultValue= "10") int lines,
			@RequestParam(value="dir", defaultValue= "ASC") String dir){
				
		Pageable pagination = PageRequest.of(page, lines, Direction.valueOf(dir), "name");  
		Optional<Page<Doctor>> list = service.list(pagination);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(path= "/{id}")
	public ResponseEntity<Optional<Doctor>> find(@PathVariable Long id){
		Optional<Doctor> doctor = service.find(id);
		return doctor.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(doctor)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Optional<Doctor>> create(@RequestBody DoctorPersistDto dto, HttpServletResponse response){
		Optional<Doctor> doctor = service.save(Doctor.getDomainFrom(dto));
		publicher.publishEvent( new CreatedResourceEvent(this, response, doctor.get().getId(), "id"));
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
	
	@PutMapping(path= "/{id}")
	public ResponseEntity<Optional<Doctor>> update(@PathVariable Long id, @RequestBody DoctorDto dto){
		Optional<Doctor> doctorCurrent = service.update(id, Doctor.getDomainFrom(dto));
		return ResponseEntity.status(HttpStatus.OK).body(doctorCurrent);
	}
	
	@DeleteMapping(path= "/{id}")
	public void delete(@PathVariable Long id) {
		service.remove(id);
		ResponseEntity.status(HttpStatus.OK).build();
	}
}

