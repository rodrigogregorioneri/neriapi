package app.api.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import app.api.entities.*;
import app.api.business.*;

@RestController
@RequestMapping(value = "/api/rest/Pedidos")
public class PedidosREST {


  @Autowired
  @Qualifier("PedidosBusiness")
  private PedidosBusiness pedidosBusiness;

 
  @RequestMapping(method = RequestMethod.POST)
  public List<Pedidos> post(@Validated @RequestBody final List<Pedidos> entity) throws Exception {
	  System.out.println(entity.toString());
    return pedidosBusiness.post(entity);
  }


  @RequestMapping(method = RequestMethod.PUT)
  public Pedidos put(@Validated @RequestBody final Pedidos entity) throws Exception {
    return pedidosBusiness.put(entity);
  }

 
  @RequestMapping(method = RequestMethod.PUT, value = "/{pedidosId}/{datada_cadastro}")
  public Pedidos put(@Validated @RequestBody final Pedidos entity, @PathVariable("pedidosId") java.lang.String pedidosId, @PathVariable("datada_cadastro") java.lang.String  datada_cadastro) throws Exception {
    return pedidosBusiness.put(entity);
  }  

  @RequestMapping(method = RequestMethod.DELETE, value = "/{pedidosId}")
  public void delete(@PathVariable("pedidosId") java.lang.String pedidosId) throws Exception {
    pedidosBusiness.delete(pedidosId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<PagedResources<Pedidos>> listParams(Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(pedidosBusiness.list(pageable)), HttpStatus.OK);    
  }


  @RequestMapping(method = RequestMethod.GET, value = "/{pedidosId}")
  public Pedidos get(@PathVariable("pedidosId") java.lang.String pedidosId,@PathVariable("numero_controle") java.lang.Long numero_controle) throws Exception {
    return pedidosBusiness.get(pedidosId, numero_controle);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/specificSearch")
  public HttpEntity<PagedResources<Pedidos>> specificSearch(java.lang.String id, java.lang.Integer numero_controle, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(pedidosBusiness.specificSearch(id, numero_controle, pageable)), HttpStatus.OK);
  }

}
