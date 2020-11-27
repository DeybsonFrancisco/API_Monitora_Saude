package br.com.DeybsonFrancisco.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T>{

	Optional<T> save(T entity);
	
	Optional<T> update(Long id, T entity);
	
	void remove(Long id);
	
	Optional<Page<T>> list(Pageable page);
	
	Optional<T> find(Long id);
	
	
}
