package br.com.DeybsonFrancisco.domain.dto.doctor;

import br.com.DeybsonFrancisco.domain.entities.Doctor;

public class DoctorPersistDto {
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String occupationArea;
	
	
	public static DoctorPersistDto getDomainFrom(Doctor doctor) {
		return new DoctorPersistDto(
				doctor.getName(),
				doctor.getEmail(),
				doctor.getPassword(),
				doctor.getOccupationArea()
				);
	}
	

	public DoctorPersistDto(String name, String email, String password, String occupationArea) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.occupationArea = occupationArea;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOccupationArea() {
		return occupationArea;
	}

	public void setOccupationArea(String occupationArea) {
		this.occupationArea = occupationArea;
	}
	
	

}
