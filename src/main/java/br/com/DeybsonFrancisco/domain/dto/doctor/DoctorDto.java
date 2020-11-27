package br.com.DeybsonFrancisco.domain.dto.doctor;

import br.com.DeybsonFrancisco.domain.entities.Doctor;

public class DoctorDto {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String occupationArea;
	
	public static DoctorDto getDomainFrom(Doctor doctor) {
		return new DoctorDto(
				doctor.getId(),
				doctor.getName(),
				doctor.getEmail(),
				doctor.getOccupationArea());
	}
	
	public DoctorDto() {
		super();
	}

	public DoctorDto(Long id, String name, String email, String occupationArea) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.occupationArea = occupationArea;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOccupationArea() {
		return occupationArea;
	}

	public void setOccupationArea(String occupationArea) {
		this.occupationArea = occupationArea;
	}


}
