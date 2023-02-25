package pe.company.sintad.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import pe.company.sintad.model.tb_entidad;
import pe.company.sintad.repository.tb_entidad_Repository;

@Service
public class tb_entidad_Impl implements tb_entidad_Service {
	
	@Autowired
	private tb_entidad_Repository repo;

	@Override
	@Transactional
	public void insert(tb_entidad entidad) {
		repo.save(entidad);

	}

	@Override
	@Transactional
	public void update(tb_entidad entidad) {
		repo.save(entidad);

	}

	@Override
	@Transactional
	public void delete(Integer id_entidad) {
		repo.deleteById(id_entidad);

	}

	@Override
	@Transactional
	public tb_entidad findById(Integer id_entidad) {
		return repo.findById(id_entidad).orElse(null);
	}

	@Override
	@Transactional
	public Collection<tb_entidad> findAll() {
		return (Collection<tb_entidad>) repo.findAll();
	}

}
