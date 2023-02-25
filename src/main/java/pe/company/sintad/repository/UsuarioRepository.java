package pe.company.sintad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.company.sintad.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
}
