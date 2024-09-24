package com.devcap.dscatalog.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcap.dscatalog.dto.CategoryDTO;
import com.devcap.dscatalog.entities.Category;
import com.devcap.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();
		return new CategoryDTO(entity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
}
