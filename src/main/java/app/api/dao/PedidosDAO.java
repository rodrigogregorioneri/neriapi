package app.api.dao;

import app.api.entities.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

@Repository("PedidosDAO")
public interface PedidosDAO extends JpaRepository<Pedidos, java.lang.String> {

  
  @Query("SELECT entity FROM Pedidos entity WHERE entity.id = :id and entity.datada_cadastro = :datada_cadastro")
  public Pedidos findOne(@Param(value="id") java.lang.String id);
   
  @Modifying
  @Query("DELETE FROM Pedidos entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id,@Param(value="datada_cadastro") java.lang.String datada_cadastro);

  @Query("select c from Pedidos c")
  public Page<Pedidos> list(Pageable pageable);
  


}
