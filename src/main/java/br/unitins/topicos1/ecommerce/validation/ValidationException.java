package br.unitins.topicos1.ecommerce.validation;

public class ValidationException extends RuntimeException {
    
    private String fieldName;

    public ValidationException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
