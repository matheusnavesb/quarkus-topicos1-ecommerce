package br.unitins.topicos1.ecommerce.service;

import java.util.List;

import br.unitins.topicos1.ecommerce.dto.PedidoDTO;
import br.unitins.topicos1.ecommerce.dto.PedidoResponseDTO;
import br.unitins.topicos1.ecommerce.repository.PedidoRepository;
import br.unitins.topicos1.ecommerce.repository.ProdutoRepository;
import br.unitins.topicos1.ecommerce.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService{

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PedidoRepository pedidoRepository;


    @Override
    public PedidoResponseDTO insert(PedidoDTO dto, String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAll'");
    }
    
}
