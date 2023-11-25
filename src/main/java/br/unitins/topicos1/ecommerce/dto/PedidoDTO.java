package br.unitins.topicos1.ecommerce.dto;

import java.util.List;

public record PedidoDTO(

    // Pagamento pagamento,
    // EnderecoDTO endereco,
    List<ItemPedidoDTO> itens
) {
    
}
