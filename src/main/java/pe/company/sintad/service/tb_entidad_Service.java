package pe.company.sintad.service;

import java.util.Collection;

import pe.company.sintad.model.tb_entidad;

public interface tb_entidad_Service {
	
	public abstract void insert(tb_entidad entidad);
	public abstract void update(tb_entidad entidad);
	public abstract void delete(Integer id_entidad);
	public abstract tb_entidad findById(Integer id_entidad);
	public abstract Collection<tb_entidad> findAll();


}
