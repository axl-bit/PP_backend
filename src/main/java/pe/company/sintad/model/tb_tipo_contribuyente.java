package pe.company.sintad.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_contribuyente")
public class tb_tipo_contribuyente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//realizamos la integracions de los parametros para los datos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_contribuyente")
	private Integer id_tipo_contribuyente;
	
	@Column(name = "nombre", length = 50)
	private String nombre_contribuyente;
	
	@Column(name = "estado")
	private Boolean estado_contribuyente;
	
	@OneToMany(mappedBy = "id_tipo_contribuyente")
	@JsonBackReference(value = "tb_entidadList")
	private Collection<tb_entidad> tb_entidadList = new ArrayList<>();
	
	
	//Generamos los constructores
	
	public tb_tipo_contribuyente() {
		super();
	}


	public tb_tipo_contribuyente(String nombre_contribuyente, Boolean estado_contribuyente) {
		super();
		this.nombre_contribuyente = nombre_contribuyente;
		this.estado_contribuyente = estado_contribuyente;
	}
	
	//Generamos los Getters y Setters

	public Integer getId_tipo_contribuyente() {
		return id_tipo_contribuyente;
	}


	public void setId_tipo_contribuyente(Integer id_tipo_contribuyente) {
		this.id_tipo_contribuyente = id_tipo_contribuyente;
	}


	public String getNombre_contribuyente() {
		return nombre_contribuyente;
	}


	public void setNombre_contribuyente(String nombre_contribuyente) {
		this.nombre_contribuyente = nombre_contribuyente;
	}


	public Boolean getEstado_contribuyente() {
		return estado_contribuyente;
	}


	public void setEstado_contribuyente(Boolean estado_contribuyente) {
		this.estado_contribuyente = estado_contribuyente;
	}
	
}
