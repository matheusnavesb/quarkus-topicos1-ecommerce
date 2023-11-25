package br.unitins.topicos1.ecommerce.dto;

import br.unitins.topicos1.ecommerce.model.Telefone;

public record TelefoneDTO(

    String codigoArea,
    String numero
) {
    public static TelefoneDTO valueOf(Telefone telefone){
        return new TelefoneDTO(
            telefone.getCodigoArea(),
            telefone.getNumero()
        );
    }
}
