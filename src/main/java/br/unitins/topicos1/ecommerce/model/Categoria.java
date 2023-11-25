package br.unitins.topicos1.ecommerce.model;

public enum Categoria {
    
    MECANICA(1, "Mecanica"),
    SUSPENSAO(2, "Suspensao"),
    DIRECAO(3, "Direcao"),
    ESTETICA(4, "Estetica"),
    ELETRICA(5, "Eletrica");

    private final Integer id;
    private final String label;

    Categoria(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Categoria valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getId().equals(id))
                return categoria;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
    
}
