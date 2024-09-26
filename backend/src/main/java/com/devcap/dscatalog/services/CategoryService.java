package com.devcap.dscatalog.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcap.dscatalog.dto.CategoryDTO;
import com.devcap.dscatalog.entities.Category;
import com.devcap.dscatalog.repositories.CategoryRepository;
import com.devcap.dscatalog.services.exceptions.DatabaseException;
import com.devcap.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest){
		Page<Category> list = repository.findAll(pageRequest);
		return list.map(x -> new CategoryDTO(x));
	
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new CategoryDTO(entity);
	}
	
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
		
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
			Category entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new CategoryDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		} catch (DataIntegrityViolationException e ) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	//antes do tratamento de erro em service:
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();
		return new CategoryDTO(entity);
	}
	*/


	/*  antes do page
	  @Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	
	}
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* FOR
	List<CategoryDTO> listDto = new ArrayList<>();
	for(Category cat : list) {
		listDto.add(new CategoryDTO(cat));
	}
	return listDto;
	
	*/
	
	
	/*  //NO DTO
	@Transactional(readOnly = true)
	public List<Category> findAll(){
		return repository.findAll();
	*/

