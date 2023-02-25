package pe.company.sintad.service;

import java.util.Collection;

import pe.company.sintad.model.tb_tipo_documento;

public interface tb_tipo_documento_Service {
	
	public abstract void insert(tb_tipo_documento tpd);
	public abstract void update(tb_tipo_documento tpd);
	public abstract void delete(Integer id_tipo_documento);
	public abstract tb_tipo_documento findById(Integer id_tipo_documento);
	public abstract Collection<tb_tipo_documento> findAll();

}
