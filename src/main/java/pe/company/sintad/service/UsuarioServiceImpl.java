package pe.company.sintad.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.company.sintad.model.Usuario;
import pe.company.sintad.model.UsuarioRol;
import pe.company.sintad.repository.RolRepository;
import pe.company.sintad.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		
		//obtenemos el usuario local
		Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
		
		if(usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario yaesta presente");
		}
		else {
			for(UsuarioRol usuarioRol: usuarioRoles) {
				rolRepository.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = usuarioRepository.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
		
	}

}
