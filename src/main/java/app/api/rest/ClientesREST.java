package app.api.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

import app.api.business.*;
import app.api.entities.Clientes;
import app.api.entities.Pedidos;


@RestController
@RequestMapping(value = "/api/rest/Clientes")
public class ClientesREST {

  @Autowired
  @Qualifier("ClientesBusiness")
  private ClientesBusiness clientesBusiness;

  @RequestMapping(method = RequestMethod.POST)
  public Clientes post(@Validated @RequestBody final Clientes entity) throws Exception {
    return clientesBusiness.post(entity);
  }

 
  @RequestMapping(method = RequestMethod.PUT)
  public Clientes put(@Validated @RequestBody final Clientes entity) throws Exception {
    return clientesBusiness.put(entity);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{clientesId}")
  public Clientes put(@Validated @RequestBody final Clientes entity, @PathVariable("clientesId") java.lang.String clientesId) throws Exception {
    return clientesBusiness.put(entity);
  }  


  @RequestMapping(method = RequestMethod.DELETE, value = "/{clientesId}")
  public void delete(@PathVariable("clientesId") java.lang.String clientesId) throws Exception {
    clientesBusiness.delete(clientesId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<PagedResources<Clientes>> listParams(Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(clientesBusiness.list(pageable)), HttpStatus.OK);    
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{clientesId}")
  public Clientes get(@PathVariable("clientesId") java.lang.String clientesId) throws Exception {
    return clientesBusiness.get(clientesId);
  }
}
