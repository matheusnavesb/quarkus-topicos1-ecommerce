package br.unitins.topicos1.ecommerce.repository;

import br.unitins.topicos1.ecommerce.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> { 
    
}
