package br.com.DeybsonFrancisco.domain.dto.patient;

import java.util.Date;

import br.com.DeybsonFrancisco.domain.entities.Patient;

public class PatientPersistDto {
	
	private String name;
	
	private String email;
	
	private String password; 
	
	private Date birthDate;
	
	private char sex;
	
	private boolean comorbidities;
	
	public static PatientPersistDto getDomainFrom(Patient patient) {
		return new PatientPersistDto(
				patient.getName(),
				patient.getEmail(),
				patient.getPassword(),
				patient.getBirthDate(),
				patient.getSex(),
				patient.isComorbidities());
	}

	public PatientPersistDto(String name, String email, String password, Date birthDate, char sex, boolean comorbidities) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.sex = sex;
		this.comorbidities = comorbidities;
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
