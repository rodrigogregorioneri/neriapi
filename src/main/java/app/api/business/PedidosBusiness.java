package app.api.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.api.dao.PedidosDAO;
import app.api.entities.Pedidos;;

@Service("PedidosBusiness")
public class PedidosBusiness {


  @Autowired
  @Qualifier("PedidosDAO")
  protected PedidosDAO repository;

  public List<Pedidos> post(final List<Pedidos> entity) throws Exception {
	  for(Pedidos pedido : entity) {
		    if(pedido.getQuantidade() >= 5 &&  pedido.getQuantidade() < 9) {
		    	pedido.setValor(pedido.getValor()-(pedido.getValor() * 0.05));
		    }else if(entity.get(0).getQuantidade() >= 10) {
		    	((Pedidos) entity).setValor(pedido.getValor()-(pedido.getValor() * 0.10));
		    }
	  }
	  
	  

    List<Pedidos> result = repository.save(entity);
    System.out.println(result.toString());
    return result;
  }

  public Pedidos put(final Pedidos entity) throws Exception {
    Pedidos result = repository.saveAndFlush(entity);
    return result;
  }

  public void delete(java.lang.String id) throws Exception {
    Pedidos entity = this.get(id);
    this.repository.delete(entity);       
  }
  
  public Pedidos get(java.lang.String id) throws Exception {
    Pedidos result = repository.findOne(id);
    return result;
  }

  public Page<Pedidos> list(Pageable pageable){
    Page<Pedidos> result = repository.list(pageable);
    return result;
  }
}

