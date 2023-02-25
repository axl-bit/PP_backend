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
@Table(name = "tb_tipo_documento")
public class tb_tipo_documento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//realizamos la integracions de los parametros para los datos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_documento", unique = true)
	private Integer id_tipo_documento;
	
	@Column(name="codigo", length = 20, nullable = false, unique = true)
	private String codigo_tipodoc;
	
	@Column(name="nombre", length = 100, nullable = false)
	private String nombre_tipodoc;
	
	@Column(name="descripcion", nullable = false)
	private String descripcion_tipodoc;
	
	@Column(name="estado", nullable = false)
	private Boolean estado_tipodoc;
	
	@OneToMany(mappedBy = "id_tipo_documento")
	@JsonBackReference(value = "tb_tipo_documentoList")
	private Collection<tb_entidad> tb_tipo_documentoList = new ArrayList<>();
	
	//Generamos los constructores
	
	public tb_tipo_documento() {
		super();
	}

	public tb_tipo_documento(String codigo, String nombre, String descripcion, Boolean estado) {
		super();
		this.codigo_tipodoc = codigo;
		this.nombre_tipodoc = nombre;
		this.descripcion_tipodoc = descripcion;
		this.estado_tipodoc = estado;
	}
	
	//Generamos los getter y setters

	public Integer getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(Integer id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public String getCodigo_tipodoc() {
		return codigo_tipodoc;
	}

	public void setCodigo_tipodoc(String codigo) {
		this.codigo_tipodoc = codigo;
	}

	public String getNombre_tipodoc() {
		return nombre_tipodoc;
	}

	public void setNombre_tipodoc(String nombre) {
		this.nombre_tipodoc = nombre;
	}

	public String getDescripcion_tipodoc() {
		return descripcion_tipodoc;
	}

	public void setDescripcion_tipodoc(String descripcion) {
		this.descripcion_tipodoc = descripcion;
	}

	public Boolean getEstado_tipodoc() {
		return estado_tipodoc;
	}

	public void setEstado_tipodoc(Boolean estado) {
		this.estado_tipodoc = estado;
	}
	
}
