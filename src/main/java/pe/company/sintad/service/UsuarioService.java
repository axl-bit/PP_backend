package pe.company.sintad.service;

import java.util.Set;

import pe.company.sintad.model.Usuario;
import pe.company.sintad.model.UsuarioRol;

public interface UsuarioService {
	
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
	
}
