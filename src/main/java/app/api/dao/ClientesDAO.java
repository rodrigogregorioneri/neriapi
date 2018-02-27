package app.api.dao;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*;

import app.api.entities.Clientes;
import app.api.entities.Pedidos; 


@Repository("ClientesDAO")
public interface ClientesDAO extends JpaRepository<Clientes, java.lang.String> {
  
  @Query("SELECT entity FROM Clientes entity WHERE entity.id = :id")
  public Clientes findOne(@Param(value="id") java.lang.String id);
   
  @Modifying
  @Query("DELETE FROM Clientes entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  @Query("select c from Clientes c")
  public Page<Clientes> list(Pageable pageable);
  
  @Query("SELECT entity FROM Pedidos entity WHERE entity.id = :id")
  public Page<Pedidos> findPedidos(@Param(value="id") java.lang.String id, Pageable pageable);

}
