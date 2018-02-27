package app.api.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.api.dao.*;
import app.api.entities.Clientes;
import app.api.entities.Pedidos;


@Service("ClientesBusiness")
public class ClientesBusiness {


  @Autowired
  @Qualifier("ClientesDAO")
  protected ClientesDAO repository;

  public Clientes post(final Clientes entity) throws Exception {
    Clientes result = repository.save(entity);
    return result;
  }

  public Clientes put(final Clientes entity) throws Exception {
    Clientes result = repository.saveAndFlush(entity);
    return result;
  }

  public void delete(java.lang.String id) throws Exception {
    Clientes entity = this.get(id);
    this.repository.delete(entity);       
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public Clientes get(java.lang.String id) throws Exception {
    Clientes result = repository.findOne(id);
    return result;
  }

  // CRUD
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Clientes> list(Pageable pageable){
    Page<Clientes> result = repository.list(pageable);
    return result;
  }
  
  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Pedidos> findPedidos(java.lang.String id, Pageable pageable) { 
    Page<Pedidos> result = repository.findPedidos(id, pageable);      
    return result;    
  }
}
