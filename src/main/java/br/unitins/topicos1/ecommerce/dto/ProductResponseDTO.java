package br.unitins.topicos1.ecommerce.dto;

import br.unitins.topicos1.ecommerce.model.Category;
import br.unitins.topicos1.ecommerce.model.Product;


public record ProductResponseDTO(

    Long id,
    String nome,
    String descricao,
    Category category,
    Double preco,
    Integer estoque,
    String nomeImagem
) {
    
    public static ProductResponseDTO valueOf(Product product) {
        return new ProductResponseDTO(
            product.getId(), 
            product.getNome(),
            product.getDescricao(),
            product.getCategory(),
            product.getPreco(),
            product.getEstoque(),
            product.getNomeImagem()
        );
    }
}
