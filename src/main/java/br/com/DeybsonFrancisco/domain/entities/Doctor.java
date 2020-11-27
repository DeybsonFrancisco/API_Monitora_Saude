package br.com.DeybsonFrancisco.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.DeybsonFrancisco.domain.dto.doctor.DoctorDto;
import br.com.DeybsonFrancisco.domain.dto.doctor.DoctorPersistDto;

@Entity
public class Doctor  extends User{
	
	@Column
	private String occupationArea;
	
	
	public static Doctor getDomainFrom(DoctorDto dto) {
		return new Doctor(
				dto.getId(),
				dto.getName(),
				dto.getEmail(),
				dto.getOccupationArea());
	}

	public static Doctor getDomainFrom(DoctorPersistDto dto) {
		return new Doctor(
				dto.getName(),
				dto.getEmail(),
				dto.getPassword(),
				dto.getOccupationArea());
	}
	
	public Doctor() {
		super();
	}

	public Doctor(String name, String email, String password, String occpationArea) {
		super(name, email, password);
		this.occupationArea = occpationArea;
	}
	
	public Doctor(Long id, String name, String email, String occpationArea) {
		super(id, name, email);
		this.occupationArea = occpationArea;
	}

	public String getOccupationArea() {
		return occupationArea;
	}

	public void setOccupationArea(String occupationArea) {
		this.occupationArea = occupationArea;
	}

	@Override
	public String toString() {
		return "Doctor [occupationArea=" + occupationArea + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((occupationArea == null) ? 0 : occupationArea.hashCode());
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
		Doctor other = (Doctor) obj;
		if (occupationArea == null) {
			if (other.occupationArea != null)
				return false;
		} else if (!occupationArea.equals(other.occupationArea))
			return false;
		return true;
	}

}
