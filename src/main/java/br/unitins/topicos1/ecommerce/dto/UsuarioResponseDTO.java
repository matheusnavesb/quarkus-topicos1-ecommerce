package br.unitins.topicos1.ecommerce.dto;

import java.util.List;

import br.unitins.topicos1.ecommerce.model.Perfil;
import br.unitins.topicos1.ecommerce.model.Usuario;

public record UsuarioResponseDTO(

    Long id,
    String nome,
    String login,
    String senha,
    Perfil perfil,
    List<TelefoneDTO> listaTelefone
    
) {
    public static UsuarioResponseDTO valueOf(Usuario usuario){

        if(usuario == null){
            return null;
        }
        
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getLogin(),
            usuario.getSenha(),
            usuario.getPerfil(),
            usuario.getListaTelefone()
                .stream()
                .map(t -> TelefoneDTO.valueOf(t)).toList()
        );
    }
}