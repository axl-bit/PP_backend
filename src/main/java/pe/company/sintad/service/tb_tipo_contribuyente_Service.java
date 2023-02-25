package pe.company.sintad.service;

import java.util.Collection;

import pe.company.sintad.model.tb_tipo_contribuyente;

public interface tb_tipo_contribuyente_Service {
	
	public abstract void insert(tb_tipo_contribuyente tpc);
	public abstract void update(tb_tipo_contribuyente tpc);
	public abstract void delete(Integer id_tipo_contribuyente);
	public abstract tb_tipo_contribuyente findById(Integer id_tipo_contribuyente);
	public abstract Collection<tb_tipo_contribuyente> findAll();
	

}
