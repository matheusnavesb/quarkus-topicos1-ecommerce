package br.unitins.topicos1.ecommerce.resource;
/*
import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.topicos1.ecommerce.dto.PedidoDTO;
import br.unitins.topicos1.ecommerce.dto.PedidoResponseDTO;
import br.unitins.topicos1.ecommerce.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {
    
    @Inject
    PedidoService service;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JsonWebToken jwt;


    @POST
    @RolesAllowed({"User"})
    public Response insert(PedidoDTO dto) {

        String login = jwt.getSubject();
        
        PedidoResponseDTO retorno = service.insert(dto, login);
        return Response.status(201).entity(retorno).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll() {
        
        return Response.ok(service.findByAll()).build();
    }
}*/