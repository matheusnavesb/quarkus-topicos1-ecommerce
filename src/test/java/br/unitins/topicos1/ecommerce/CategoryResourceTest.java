package br.unitins.topicos1.ecommerce;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

//import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.ecommerce.dto.CategoryDTO;
import br.unitins.topicos1.ecommerce.dto.CategoryResponseDTO;
import br.unitins.topicos1.ecommerce.service.CategoryService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class CategoryResourceTest {
    
    @Inject
    CategoryService categoryService;

    @Test
    public void testInsert(){
        
        //List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
        //produtos.add(new ProdutoDTO("Produto 2", "Kit mecanica Gurgel", 999.99, 5));

        CategoryDTO dto = new CategoryDTO(
            "Baterias"
            );

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/categories")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
        "category", is("Baterias")
        );
}

    @Test
    public void testUpdate() {
        //List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
        //produtos.add(new ProdutoDTO("Produto 10", "Kit mecanica Fiat Escada", 1999.99, 3));

        CategoryDTO categoryDTO = new CategoryDTO("Baterias"); 
        
        // inserindo uma category
        CategoryResponseDTO categoryTest = categoryService.create(categoryDTO);

        Long id = categoryTest.id();

        CategoryDTO dtoUpdate = new CategoryDTO("BATERIA ELETRIC CAR");

        given()
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/categories/"+ id)
            .then()
            .statusCode(200);
    }
}
