package br.unitins.topicos1.ecommerce;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

//import java.util.ArrayList;
//import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.ecommerce.dto.ProductDTO;
import br.unitins.topicos1.ecommerce.service.ProductService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class ProductResourceTest {
    
    @Inject
    ProductService productService;

    @Test
    public void testFindAll() {
        given()
          .when().get("/products")
          .then()
             .statusCode(200);
    }

    @Test
    public void testInsert() {

        ProductDTO productDTO = new ProductDTO(
            "Produto Insert",
            "Descricao produto insert",
            (long) 1,
            199.00,
            100,
            "nomeImagem"
        );

        given()
        .contentType(ContentType.JSON)
        .body(productDTO)
        .when().post("/products")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
         "nome",is("Produto Insert"),
         "descricao",is("Descricao produto insert"));
    }

}
