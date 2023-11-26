package br.unitins.topicos1.ecommerce.service;

import java.util.List;

import br.unitins.topicos1.ecommerce.dto.ProdutoDTO;
import br.unitins.topicos1.ecommerce.dto.ProdutoResponseDTO;
import br.unitins.topicos1.ecommerce.model.Categoria;
import br.unitins.topicos1.ecommerce.model.Produto;
import br.unitins.topicos1.ecommerce.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;


@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService{

    @Inject
    ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public ProdutoResponseDTO insert(@Valid ProdutoDTO dto) {

        Produto novoProduto = new Produto();
        novoProduto.setNome(dto.nome());
        novoProduto.setDescricao(dto.descricao());
        novoProduto.setCategoria(Categoria.valueOf(dto.idCategoria()));
        novoProduto.setPreco(dto.preco());
        novoProduto.setEstoque(dto.estoque());
       
        produtoRepository.persist(novoProduto);

       return ProdutoResponseDTO.valueOf(novoProduto);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id);

        if (produtoRepository.findById(id) == null || produto.getId() == null) {

            produto.setId(id);
            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setCategoria(Categoria.valueOf(dto.idCategoria()));
            produto.setPreco(dto.preco());
            produto.setEstoque(dto.estoque());
        }

        return ProdutoResponseDTO.valueOf(produto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!produtoRepository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        return ProdutoResponseDTO.valueOf(produtoRepository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.listAll().stream()
                .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByNome(String nome) {
        return produtoRepository.findByNome(nome).stream()
                .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    

    



    
}
