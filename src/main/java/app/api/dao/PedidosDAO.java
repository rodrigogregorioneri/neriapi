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

  
  @Query("SELECT entity FROM Pedidos entity WHERE entity.id = :id or entity.numero_controle = :numero_controle")
  public Pedidos findOne(@Param(value="id") java.lang.String id,@Param(value="numero_controle") java.lang.Long numero_controle);
   
  @Modifying
  @Query("DELETE FROM Pedidos entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  @Query("select c from Pedidos c")
  public Page<Pedidos> list(Pageable pageable);

  @Query("SELECT entity FROM Pedidos entity WHERE (:id is null OR entity.id like concat('%',:id,'%')) AND (:numero_controle is null OR entity.numero_controle = :numero_controle)")
  public Page<Pedidos> specificSearch(@Param(value="id") java.lang.String id, @Param(value="numero_controle") java.lang.Integer numero_controle, Pageable pageable);




}
