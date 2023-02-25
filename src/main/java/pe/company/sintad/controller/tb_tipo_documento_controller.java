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

import pe.company.sintad.model.tb_tipo_documento;
import pe.company.sintad.service.tb_tipo_documento_Service;

@RestController
@RequestMapping("/tipodoc")
public class tb_tipo_documento_controller {
	
	
	//Obtenemos los metodos de la interfaz
	@Autowired
	private tb_tipo_documento_Service service;
	
	
	//Creamos el metodo para listar los tipos de documentos
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		try {
			
			Collection<tb_tipo_documento> tipodoc = service.findAll();
			return new ResponseEntity<>(tipodoc, HttpStatus.OK);
			
		} catch (Exception e) {
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al encontrar los tipos de documentos: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//creamos el metodo para buscar un tipodoc por su id
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer idtipodoc){
		
		try {
			//obtenemos el modelo de tipodoc
			tb_tipo_documento tipodoc = service.findById(idtipodoc);
			
			if(tipodoc == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se pudo encontrar el tipo de documento");	
			}
			
			//retornamos el tipo de documento encontrado y damos el estatus de ok
			return new ResponseEntity<>(tipodoc, HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al encontrar el tipo de documento: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//creamos el metodo para agregar tipos de documentos
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody tb_tipo_documento tipodoc){
		try {
						
			//llamamos al servicio y le damos los datos que obtenemos
			service.insert(tipodoc);
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("codigo", "OK");
			respuesta.put("mensaje", "se agrego correctamente el tipo de documento");
			
			return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al agregar el tipo de documento: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//creamos el metodo para realizar la edicion de el tipodoc
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody tb_tipo_documento tipodoc){
		try {
			
			//obtenemos los datos del tipo de documento actual y lo almacenamos
			tb_tipo_documento tipodocActual = service.findById(id);
			
			if(tipodocActual != null) {
				
				//cargamos los datos a cambiar
				tipodocActual.setNombre_tipodoc(tipodoc.getNombre_tipodoc());
				tipodocActual.setCodigo_tipodoc(tipodoc.getCodigo_tipodoc());
				tipodocActual.setDescripcion_tipodoc(tipodoc.getDescripcion_tipodoc());
				tipodocActual.setEstado_tipodoc(tipodoc.getEstado_tipodoc());
				
				//realizamos los cambios
				service.update(tipodocActual);
				
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("codigo", "OK");
				respuesta.put("mensaje", "se actualizo correctamente el tipo de documento");
				
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
				
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al editar el tipo de documento: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//creamos el metodo para eliminar un tipo de documento
	//esta opcion es poco recomendable,ya que, es mejor usar un apartado de estado para así manejarlo mejor
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable Integer id){
		try {
			
			//ingresamos el id para obtener el tipo de documento a eliminar 
			tb_tipo_documento tipodoc = service.findById(id);
			
			if(tipodoc != null) {
				
				service.delete(id);
				
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("mensaje", "se elimino correctamente el tipo de documento");
				
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al editar el tipo de documento: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	

}
