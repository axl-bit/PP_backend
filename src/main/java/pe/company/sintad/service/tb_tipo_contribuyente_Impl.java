package pe.company.sintad.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import pe.company.sintad.model.tb_tipo_contribuyente;
import pe.company.sintad.repository.tb_tipo_contribuyente_Repository;

@Service
public class tb_tipo_contribuyente_Impl implements tb_tipo_contribuyente_Service {

	@Autowired
	private tb_tipo_contribuyente_Repository repo;
	
	@Override
	@Transactional
	public void insert(tb_tipo_contribuyente tpc) {
		repo.save(tpc);

	}

	@Override
	@Transactional
	public void update(tb_tipo_contribuyente tpc) {
		repo.save(tpc);

	}

	@Override
	@Transactional
	public void delete(Integer id_tipo_contribuyente) {
		repo.deleteById(id_tipo_contribuyente);

	}

	@Override
	@Transactional
	public tb_tipo_contribuyente findById(Integer id_tipo_contribuyente) {
		return repo.findById(id_tipo_contribuyente).orElse(null);
	}

	@Override
	@Transactional
	public Collection<tb_tipo_contribuyente> findAll() {
		return (Collection<tb_tipo_contribuyente>) repo.findAll();
	}

}
