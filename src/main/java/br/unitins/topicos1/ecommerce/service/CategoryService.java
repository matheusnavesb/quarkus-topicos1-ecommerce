package br.unitins.topicos1.ecommerce.service;

import java.util.List;

import br.unitins.topicos1.ecommerce.dto.CategoryDTO;
import br.unitins.topicos1.ecommerce.dto.CategoryResponseDTO;
import jakarta.validation.Valid;

public interface CategoryService {

    CategoryResponseDTO findById(Long id);
    
    CategoryResponseDTO create(@Valid CategoryDTO dto);
    
    CategoryResponseDTO update(Long id, CategoryDTO dto);
    
    void delete(Long id);

    public List<CategoryResponseDTO> findByAll();
} 
