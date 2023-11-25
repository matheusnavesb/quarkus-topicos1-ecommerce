package br.unitins.topicos1.ecommerce.service;

import br.unitins.topicos1.ecommerce.dto.UsuarioResponseDTO;

public interface JwtService {

    public String generateJwt(UsuarioResponseDTO dto);
    
} 
