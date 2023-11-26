package br.unitins.topicos1.ecommerce.service;

import java.util.List;

import br.unitins.topicos1.ecommerce.dto.ProdutoDTO;
import br.unitins.topicos1.ecommerce.dto.ProdutoResponseDTO;
import jakarta.validation.Valid;

public interface ProdutoService {

    
    ProdutoResponseDTO insert(@Valid ProdutoDTO dto);
    
    ProdutoResponseDTO update(Long id, ProdutoDTO dto);

    void delete(Long id);

    ProdutoResponseDTO findById(Long id);

    List<ProdutoResponseDTO> findAll();

    List<ProdutoResponseDTO> findByNome(String nome);
} 
