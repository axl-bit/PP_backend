package pe.company.sintad.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_entidad")
public class tb_entidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_entidad")
	private Integer id_entidad;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_documento", nullable = false, 
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign Key(id_tipo_documento) references tb_tipo_documento(id_tipo_documento)"))
	private tb_tipo_documento id_tipo_documento;
	
	@Column(name = "nro_documento")
	private String nro_documento;
	
	@Column(name = "razon_social")
	private String razon_social;
	
	@Column(name = "nombre_comercial")
	private String nombre_comercial;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_contribuyente", nullable = false, 
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign Key(id_tipo_contribuyente) references tb_tipo_contribuyente(id_tipo_contribuyente)"))
	private tb_tipo_contribuyente id_tipo_contribuyente;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono_entidad;
	
	@Column(name = "estado")
	private Boolean estado_entidad;
	
	//Generamos los constructores
	
	public tb_entidad() {
		super();
	}

	public tb_entidad(tb_tipo_documento id_tipo_documento, String nro_documento, String razon_social,
			String nombre_comercial, tb_tipo_contribuyente idtipocontribuyente, String direccion, String telefono,
			Boolean estado_entidad) {
		super();
		this.id_tipo_documento = id_tipo_documento;
		this.nro_documento = nro_documento;
		this.razon_social = razon_social;
		this.nombre_comercial = nombre_comercial;
		this.id_tipo_contribuyente = idtipocontribuyente;
		this.direccion = direccion;
		this.telefono_entidad = telefono;
		this.estado_entidad = estado_entidad;
	}
	
	//Generamos los Getters y Setters

	public Integer getId_entidad() {
		return id_entidad;
	}

	public void setId_entidad(Integer id_entidad) {
		this.id_entidad = id_entidad;
	}

	public tb_tipo_documento getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(tb_tipo_documento id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNombre_comercial() {
		return nombre_comercial;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public tb_tipo_contribuyente getId_tipo_contribuyente() {
		return id_tipo_contribuyente;
	}

	public void setId_tipo_contribuyente(tb_tipo_contribuyente idtipocontribuyente) {
		this.id_tipo_contribuyente = idtipocontribuyente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono_entidad() {
		return telefono_entidad;
	}

	public void setTelefono_entidad(String telefono) {
		this.telefono_entidad = telefono;
	}

	public Boolean getEstado_entidad() {
		return estado_entidad;
	}

	public void setEstado_entidad(Boolean estado_entidad) {
		this.estado_entidad = estado_entidad;
	}
	
}
