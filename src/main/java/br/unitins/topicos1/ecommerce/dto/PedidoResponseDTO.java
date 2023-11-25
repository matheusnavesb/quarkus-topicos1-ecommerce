package br.unitins.topicos1.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.ecommerce.model.Pedido;

public record PedidoResponseDTO(

    Long id,
    LocalDateTime dataHora,
    UsuarioResponseDTO usuario,
    Double totalPedido,
    List<ItemPedidoResponseDTO> itens

) {
    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
            pedido.getId(), 
            pedido.getDataHoraPedido(),
            UsuarioResponseDTO.valueOf(pedido.getUsuario()),
            pedido.getTotalPedido(),
            ItemPedidoResponseDTO.valueOf(pedido.getItens()));
    }
} 
    

