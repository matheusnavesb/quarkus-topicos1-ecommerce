package br.unitins.topicos1.ecommerce.service;

import java.util.List;

import br.unitins.topicos1.ecommerce.dto.PedidoDTO;
import br.unitins.topicos1.ecommerce.dto.PedidoResponseDTO;

public interface PedidoService {

    public PedidoResponseDTO insert(PedidoDTO dto, String login);

    public PedidoResponseDTO findById(Long id);

    public List<PedidoResponseDTO> findByAll();

    public List<PedidoResponseDTO> findByAll(String login);
} 
