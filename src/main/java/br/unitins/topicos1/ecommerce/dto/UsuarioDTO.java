package br.unitins.topicos1.ecommerce.dto;

import java.util.List;

//import br.unitins.topicos1.ecommerce.annotation.CPF;
//import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO (

        String nome,
        String login,
        String senha,
        String cpf,
        Integer idPerfil,
        List<TelefoneDTO> listaTelefone,
        List<EnderecoDTO> listaEndereco
)
{


}

