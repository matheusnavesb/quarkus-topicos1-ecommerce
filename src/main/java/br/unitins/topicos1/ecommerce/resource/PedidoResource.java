package br.unitins.topicos1.ecommerce.resource;

import java.time.LocalDateTime;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.topicos1.ecommerce.dto.PedidoDTO;
import br.unitins.topicos1.ecommerce.dto.PedidoResponseDTO;
import br.unitins.topicos1.ecommerce.service.PedidoService;
import br.unitins.topicos1.ecommerce.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @POST
    @RolesAllowed({"User", "Admin"})
    public Response insert(PedidoDTO dto) {

        LOG.info("USUARIO REALIZANDO UM PEDIDO");

        String login = jwt.getSubject();
        
        PedidoResponseDTO retorno = service.insert(dto, login);

        LOG.info("data e hora do pedido: " + LocalDateTime.now());

        return Response.status(201).entity(retorno).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll() {
        
        LOG.info("BUSCANDO TODOS OS PEDIDOS FEITOS POR ESSE USUARIO");
        
        return Response.ok(service.findByAll()).build();
    }
}
