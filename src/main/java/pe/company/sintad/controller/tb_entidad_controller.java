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

import pe.company.sintad.model.tb_entidad;
import pe.company.sintad.service.tb_entidad_Service;

@RestController
@RequestMapping("/entidad")
public class tb_entidad_controller {
	
	//obtenemos los metodo de la interfaz
	@Autowired
	private tb_entidad_Service service;
	
	//Creamos el metodo para listar las entidades
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		try {
			
			Collection<tb_entidad> entidad = service.findAll();
			return new ResponseEntity<>(entidad, HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al encontrar las entidades: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	//creamos el metodo para buscar una entidad por su id
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer identidad){
		
		try {
			
			//obtenemos el modelo de entidad
			tb_entidad entidad = service.findById(identidad);
			
			if(entidad == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se pudo encontrar la entidad");
			}
			
			//retornamos la entidad
			return new ResponseEntity<>(entidad, HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al encontrar la entidad: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
	//cramos el metodo para agregar tipos de documentos
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody tb_entidad entidad){
		
		try {
			
			//llamamos al servicio y le damos los datos que obtenemos
			service.insert(entidad);
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("codigo", "OK");
			respuesta.put("mensaje", "Se agrego correctamente la entidad");
			
			return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al agregar la entidad: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
	//creamos el metodo para realizar la edicion de la entidad
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editar(@PathVariable Integer id, @RequestBody tb_entidad entidad){
		
		try {
			
			//obtenemos los datos de la entidad actual y lo almacenamos
			tb_entidad entidadActual = service.findById(id);
			
			if(entidadActual != null) {
				
				//cargamos los datos a cambiar
				entidadActual.setId_tipo_documento(entidad.getId_tipo_documento());
				entidadActual.setNro_documento(entidad.getNro_documento());
				entidadActual.setRazon_social(entidad.getRazon_social());
				entidadActual.setNombre_comercial(entidad.getNombre_comercial());
				entidadActual.setId_tipo_contribuyente(entidad.getId_tipo_contribuyente());
				entidadActual.setDireccion(entidad.getDireccion());
				entidadActual.setTelefono_entidad(entidad.getTelefono_entidad());
				entidadActual.setEstado_entidad(entidad.getEstado_entidad());
				
				//Realizamos los cambios
				service.update(entidadActual);
				
				Map<String, String> respuesta = new HashMap<>();
				respuesta.put("codigo", "OK");
				respuesta.put("mensaje", "Se actualizo correctamente la entida");
				
				return new ResponseEntity<>(respuesta, HttpStatus.OK);
				
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al editar la entidad: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	//creamos el metodopara eliminar un tipo de documento
	//esta opcion es poco recomendable,ya que, es mejor usar un apartado de estadopara así manejarlo mejor
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrar(@PathVariable Integer id){
		
		try {
			
			//ingresamos el id para obtener la entidad a eliminar 
			tb_entidad entidad = service.findById(id);
			
			if(entidad != null) {
				
				service.delete(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("mensaje", "Hubo un error al eliminar la entidad: " + e);
			
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	

}
