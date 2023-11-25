package br.unitins.topicos1.ecommerce.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.ecommerce.dto.ItemPedidoDTO;
import br.unitins.topicos1.ecommerce.dto.PedidoDTO;
import br.unitins.topicos1.ecommerce.dto.PedidoResponseDTO;
import br.unitins.topicos1.ecommerce.model.ItemPedido;
import br.unitins.topicos1.ecommerce.model.Pedido;
import br.unitins.topicos1.ecommerce.model.Produto;
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
        Pedido pedido = new Pedido();
        pedido.setDataHoraPedido(LocalDateTime.now());

        // calculo do total do pedido
        Double total = 0.0;
        for (ItemPedidoDTO itemDto : dto.itens()) {
            total += (itemDto.preco() * itemDto.quantidade());
        }
        pedido.setTotalPedido(total);

        // adicionando os itens do pedido
        pedido.setItens(new ArrayList<ItemPedido>());
        for (ItemPedidoDTO itemDto : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setPreco(itemDto.preco());
            item.setQuantidade(itemDto.quantidade());
            item.setPedido(pedido);
            Produto produto = produtoRepository.findById(itemDto.idProduto());
            item.setProduto(produto);

            // atualizado o estoque
            produto.setEstoque(produto.getEstoque() - item.getQuantidade());

            pedido.getItens().add(item);
        }

        // buscando o usuario pelo login
        pedido.setUsuario(usuarioRepository.findByLogin(login));

        // salvando no banco
        pedidoRepository.persist(pedido);

        // atualizando o estoque
  

        return PedidoResponseDTO.valueOf(pedido);
        
    }
    

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return pedidoRepository.listAll().stream()
            .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        return pedidoRepository.listAll().stream()
            .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }
    
}
