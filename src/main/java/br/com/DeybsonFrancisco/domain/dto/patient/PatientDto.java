package br.com.DeybsonFrancisco.domain.dto.patient;

import java.util.Date;

import br.com.DeybsonFrancisco.domain.entities.Patient;

public class PatientDto {
	
	private long id;
	
	private String name;
	
	private String email;
	
	private Date birthDate;
	
	private char sex;
	
	private boolean comorbidities;
	
	public static PatientDto getDomainFrom(Patient patient) {
		return new PatientDto(
				patient.getId(),
				patient.getName(),
				patient.getEmail(),
				patient.getBirthDate(),
				patient.getSex(),
				patient.isComorbidities());
	}

	public PatientDto(long id, String name, String email, Date birthDate, char sex, boolean comorbidities) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.sex = sex;
		this.comorbidities = comorbidities;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isComorbidities() {
		return comorbidities;
	}

	public void setComorbidities(boolean comorbidities) {
		this.comorbidities = comorbidities;
	}
	
	

}
