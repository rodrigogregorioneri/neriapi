package app.api.entities;
import javax.persistence.*;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "\"pedidos\"")
@XmlRootElement
public class Pedidos implements Serializable {

 
  private static final long serialVersionUID = 1L;
  
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  
  
  
  
  /**
  * @generated
  */
  @Column(name = "codigo_cliente", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.Long codigo_cliente;
  
  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "datada_cadastro", nullable = false, unique = false, insertable=true, updatable=true)
  private java.util.Date datada_cadastro;
  

  @Column(name = "nome", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.String nome;

  @Column(name = "numero_controle", nullable = true, unique = true, insertable=true, updatable=true)
  private java.lang.Integer numero_controle;
  
  @Column(name = "quantidade", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer quantidade;
  
  @Column(name = "valor", nullable = true, unique = false, insertable=true, updatable=true)
  private double valor;
  
  public Pedidos(){
  }

  
  /**
   * Obtém id
   * return id
   * @generated
   */
  public java.lang.String getId(){
    return this.id;
  }
  
  /**
   * Define id
   * @param id id
   * @generated
   */
  public Pedidos setId(java.lang.String id){
    this.id = id;
    return this;
  }
  

  public java.lang.Long getCodigo_cliente(){
    return this.codigo_cliente;
  }
  
  public Pedidos setCodigo_cliente(java.lang.Long codigo_cliente){
    this.codigo_cliente = codigo_cliente;
    return this;
  }
  
  public java.util.Date getDatada_cadastro(){
    return this.datada_cadastro;
  }
  
  public Pedidos setDatada_cadastro(java.util.Date datada_cadastro){
	if(datada_cadastro == null) {
		this.datada_cadastro = new Date();
	}else {
		this.datada_cadastro = datada_cadastro;	
	}
    return this;
  }
  

  public java.lang.String getNome(){
    return this.nome;
  }
  
  public Pedidos setNome(java.lang.String nome){
    this.nome = nome;
    return this;
  }
  
  public java.lang.Integer getNumero_controle(){
    return this.numero_controle;
  }
  

  public Pedidos setNumero_controle(java.lang.Integer numero_controle){
    this.numero_controle = numero_controle;
    return this;
  }
  
  public java.lang.Integer getQuantidade(){
    return this.quantidade;
  }
  
  public Pedidos setQuantidade(java.lang.Integer quantidade){
	if(quantidade == null) {
		this.quantidade = 1;
	}else {
		this.quantidade = quantidade;	
	}  
    return this;
  }
  

  public double getValor(){
    return this.valor;
  }
  

  public Pedidos setValor(double d){
    this.valor = d;
    return this;
  }
  

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pedidos object = (Pedidos)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }
  

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}