package br.unitins.topicos1.ecommerce.model.converterjpa;

import br.unitins.topicos1.ecommerce.model.Pagamento;
import jakarta.persistence.AttributeConverter;

public class PagamentoConverter implements AttributeConverter<Pagamento, Integer>{

    @Override
    public Integer convertToDatabaseColumn(Pagamento pagamento) {
        return (pagamento == null ? null : pagamento.getId());
    }

    @Override
    public Pagamento convertToEntityAttribute(Integer id) {
        return Pagamento.valueOf(id);
    }
}
