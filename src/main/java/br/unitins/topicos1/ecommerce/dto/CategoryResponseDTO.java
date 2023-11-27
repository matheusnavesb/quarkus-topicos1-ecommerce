package br.unitins.topicos1.ecommerce.dto;

import br.unitins.topicos1.ecommerce.model.Category;

public record CategoryResponseDTO(

    Long id,
    String category
) {
    
    public static CategoryResponseDTO valueOf(Category category) {
        return new CategoryResponseDTO(
            category.getId(), 
            category.getCategory()
        );
    }
}
