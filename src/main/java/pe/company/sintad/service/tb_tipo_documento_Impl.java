package pe.company.sintad.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import pe.company.sintad.model.tb_tipo_documento;
import pe.company.sintad.repository.tb_tipo_documento_Repository;

@Service
public class tb_tipo_documento_Impl implements tb_tipo_documento_Service {
	
	@Autowired
	private tb_tipo_documento_Repository repo;

	@Override
	@Transactional
	public void insert(tb_tipo_documento tpd) {
		repo.save(tpd);

	}

	@Override
	@Transactional
	public void update(tb_tipo_documento tpd) {
		repo.save(tpd);

	}

	@Override
	@Transactional
	public void delete(Integer id_tipo_documento) {
		repo.deleteById(id_tipo_documento);

	}

	@Override
	@Transactional
	public tb_tipo_documento findById(Integer id_tipo_documento) {
		return repo.findById(id_tipo_documento).orElse(null);
	}

	@Override
	public Collection<tb_tipo_documento> findAll() {
		return (Collection<tb_tipo_documento>) repo.findAll();
	}

}
