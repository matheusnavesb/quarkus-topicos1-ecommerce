package br.unitins.topicos1.ecommerce.model;

import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;


public class Pagamento {
    
    @OneToOne
    @MapsId
    private Pedido pedido;
}
