package br.com.DeybsonFrancisco.domain.entities;

import java.util.Date;

import javax.persistence.Entity;

import br.com.DeybsonFrancisco.domain.dto.patient.PatientDto;
import br.com.DeybsonFrancisco.domain.dto.patient.PatientPersistDto;

@Entity
public class Patient extends User {

	private Date birthDate;
	
	private char sex;
	
	private boolean comorbidities;
	
	public static Patient getDomainFrom(PatientDto dto) {
		return new Patient(
				dto.getId(),
				dto.getName(),
				dto.getEmail(),
				dto.getBirthDate(),
				dto.getSex(),
				dto.isComorbidities());
	}
	
	public static Patient getDomainFrom(PatientPersistDto dto) {
		return new Patient(
				dto.getName(),
				dto.getEmail(),
				dto.getPassword(),
				dto.getBirthDate(),
				dto.getSex(),
				dto.isComorbidities());
	}
	
	public Patient() {
	}

	public Patient(String name, String email, String password, Date birthDate, char sex, boolean comorbidities) {
		super(name, email, password);
		this.birthDate = birthDate;
		this.sex = sex;
		this.comorbidities = comorbidities;

	}
	public Patient(Long id, String name, String email, Date birthDate, char sex, boolean comorbidities) {
		super(id, name, email);
		this.birthDate = birthDate;
		this.sex = sex;
		this.comorbidities = comorbidities;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + (comorbidities ? 1231 : 1237);
		result = prime * result + sex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (comorbidities != other.comorbidities)
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [birthDate=" + birthDate + ", sex=" + sex + ", comorbidities=" + comorbidities + "]";
	}
	
	
	
}
