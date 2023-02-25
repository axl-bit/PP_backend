package pe.company.sintad;

//import java.util.HashSet;
//import java.util.Set;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import pe.company.sintad.model.Rol;
//import pe.company.sintad.model.Usuario;
//import pe.company.sintad.model.UsuarioRol;
//import pe.company.sintad.service.UsuarioService;

@SpringBootApplication
public class PpBackendApplication implements CommandLineRunner{
	
	//@Autowired
	//private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(PpBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*
		//ingresando el ADMIN
		try{
			Usuario usuario = new Usuario();

			usuario.setNombre("axel");
			usuario.setApellido("villar");
			usuario.setUsername("axel");
			usuario.setPassword("12345");
			usuario.setEmail("avillarmimbela@gmail.com");
			usuario.setTelefono("902333032");
			usuario.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setRolId(1L);
			rol.setRolNombre("ADMIN");

			Set<UsuarioRol> usuariosRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuariosRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
			System.out.println(usuarioGuardado.getUsername());
			
		}catch (Exception exception){
			exception.printStackTrace();
		}*/
	}

}