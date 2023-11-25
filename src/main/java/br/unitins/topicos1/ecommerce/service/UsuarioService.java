package br.unitins.topicos1.ecommerce.service;

import java.util.List;

import br.unitins.topicos1.ecommerce.dto.UsuarioDTO;
import br.unitins.topicos1.ecommerce.dto.UsuarioResponseDTO;
import jakarta.validation.Valid;

public interface UsuarioService {
    
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll();
}
