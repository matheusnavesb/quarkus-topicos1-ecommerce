package br.unitins.topicos1.ecommerce;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.ecommerce.dto.EnderecoDTO;
import br.unitins.topicos1.ecommerce.dto.TelefoneDTO;
import br.unitins.topicos1.ecommerce.dto.UsuarioDTO;
import br.unitins.topicos1.ecommerce.dto.UsuarioResponseDTO;
import br.unitins.topicos1.ecommerce.service.UsuarioService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class UsuarioResourceTest {

    @Inject
    UsuarioService usuarioService;


    @Test
    public void testFindAll() {
        given()
          .when().get("/usuarios")
          .then()
             .statusCode(200);
    }
    @Test
    public void testInsert(){
        List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        telefones.add(new TelefoneDTO("63","5555-5555"));
        List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        enderecos.add(new EnderecoDTO("rua 1", "numero1", "cidade 1", "estado 1", "123456789"));

        UsuarioDTO dto = new UsuarioDTO(
            "Joao Insert",
            "joaozinho",
            "333",
            "123456789",
            2, 
            telefones,
            enderecos);

        given()
        .contentType(ContentType.JSON)
        .body(dto)
        .when().post("/usuarios")
        .then()
        .statusCode(201)
        .body(
            "id", notNullValue(),
         "nome",is("Joao Insert"),
         "login",is("joaozinho"));
         //"senha",is("333"),
         //"idPerfil",is("2"),
         //telefones);
    }
    
    @Test
    public void testUpdate(){
        List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
        telefones.add(new TelefoneDTO("63","1111-1111"));
        List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
        enderecos.add(new EnderecoDTO("rua 1", "numero1", "cidade 1", "estado 1", "123456789"));

        UsuarioDTO dto = new UsuarioDTO(
             "Ronaldo Fenomeno",
            "ronaldo",
            "333",
            "123456789",
            2,
            telefones,
            enderecos);

        UsuarioResponseDTO usuarioTest = usuarioService.insert(dto);

        Long id = usuarioTest.id();
        telefones.add(new TelefoneDTO("63","5555-5555"));
        UsuarioDTO dtoUpdate = new UsuarioDTO(
             "Ronaldo Fenomeno",
            "ronaldo",
            "345",
            "123456789",
            1, 
            telefones, enderecos);

        given()
        .contentType(ContentType.JSON)
        .body(dtoUpdate)
        .when().put("/usuarios/"+ id)
        .then()
        .statusCode(204);
        //.body(
        //   "id", notNullValue(),
        //    "nome",is("Ronaldo Fenomeno"),
        //    "login",is("ronaldo"),
        //   "senha",is("345"),
        //   "idPerfil", is(1),
        //   telefones);
    }

}