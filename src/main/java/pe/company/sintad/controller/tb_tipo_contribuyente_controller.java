package pe.company.sintad.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.company.sintad.model.tb_tipo_contribuyente;
import pe.company.sintad.service.tb_tipo_contribuyente_Service;

@RestController
@RequestMapping("/tipocont")
public class tb_tipo_contribuyente_controller {

	//Obtenemos los metodos de la interfaz
	@Autowired
	private tb_tipo_contribuyente_Service service;
	
	//creamos el metodo para listar los tipos de documentos
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		try {
			
			Collection<tb_tipo_contribuyente> tipocont = service.findAll();
			return new ResponseEntity<>(tipocont, HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al encontrar los tipos de contribuyentes: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	
	//creamos el metodo para buscar un tipocont por su id
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer idtipocont){
		
		try {
			
			//obtenemso el modelo de tipocont 
			tb_tipo_contribuyente tipocont = service.findById(idtipocont);
			
			if(tipocont == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se pudo encontrar el tipo de contribuyente");
			}
			
			return new ResponseEntity<>(tipocont, HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al encontrar el tipos de contribuyente: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
	//creamos el metodo para agregar tipos de contribuyentes
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody tb_tipo_contribuyente tipocont){
		
		try {
			
			//llamamos al servicio y le damos los datos que obtenemos
			service.insert(tipocont);
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("codigo", "OK");
			respuesta.put("mensaje", "Se agrego correctamente el tipo de contribuyente");
			
			return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
			
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al agregar los tipo de contribuyente: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	//creamos el metodo para realizar la edicion de el tipo de contribuyente
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody tb_tipo_contribuyente tipocont){
		
		try {
			
			//obtenemos los datos del tipo de contribuyente actual y lo almacenamos
			tb_tipo_contribuyente tipocontActual = service.findById(id);
			
			if(tipocontActual != null) {
				
				//cargamos los datos a cambiar
				tipocontActual.setNombre_contribuyente(tipocont.getNombre_contribuyente());
				tipocontActual.setEstado_contribuyente(tipocont.getEstado_contribuyente());
				
				//realizamos los cambios 
				service.update(tipocontActual);
				
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("codigo", "OK");
				respuesta.put("mensaje", "Se edito correctamente el tipo de contribuyente");
				
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
				
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al editar los tipo de contribuyente: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	//creamos el metodo para eliminar un tipo de contribuyente
	//esta opcion es poco recomendable,ya que, es mejor usar un apartado de estado para asi manejarlo mejor
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar (@PathVariable Integer id){
		
		try {
			
			//ingresamos el id para obtener el tipo de documento a eliminar
			tb_tipo_contribuyente tipocont = service.findById(id);
			
			if(tipocont != null){
				
				service.delete(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al eliminar el tipo de contribuyente: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
}
