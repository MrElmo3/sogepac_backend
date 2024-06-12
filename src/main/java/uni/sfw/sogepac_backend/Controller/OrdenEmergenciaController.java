package uni.sfw.sogepac_backend.Controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Model.OrdenEmergencia;
import uni.sfw.sogepac_backend.Service.OrdenEmergenciaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/OrdenEmergencia")
public class OrdenEmergenciaController {
	private Logger logger = (Logger) LoggerFactory.getLogger(EnfermeraController.class);

	@Autowired
	OrdenEmergenciaService ordenEmergenciaService;
	

	@GetMapping("/all")
	public ResponseEntity<List<OrdenEmergencia>> GetAll() {
		List<OrdenEmergencia> ordenes = null;

		try {
			ordenes = ordenEmergenciaService.GetAll();
			logger.info("Ordenes encontradas");
			return ResponseEntity.ok(ordenes);
		} 
		catch (Exception e) {
			logger.error("Error al buscar ordenes", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getID")
	public ResponseEntity<OrdenEmergencia> GetById(String id) {
		OrdenEmergencia orden = null;

		try {
			orden = ordenEmergenciaService.GetById(id);
			if(orden == null) {
				logger.info("Orden no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Orden encontrada");
			return ResponseEntity.ok(orden);
		} 
		catch (Exception e) {
			logger.error("Error al buscar orden", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<OrdenEmergencia> Save(@RequestBody OrdenEmergencia orden) {
		OrdenEmergencia ordenSaved = null;

		try {
			ordenSaved = ordenEmergenciaService.Save(orden);
			logger.info("Orden guardada");
			return ResponseEntity.ok(ordenSaved);
		} 
		catch (Exception e) {
			logger.error("Error al guardar orden", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<OrdenEmergencia> Update(@RequestBody OrdenEmergencia orden) {
		OrdenEmergencia ordenUpdated = null;

		try {
			ordenUpdated = ordenEmergenciaService.Save(orden);
			logger.info("Orden actualizada");
			return ResponseEntity.ok(ordenUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar orden", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<OrdenEmergencia> Delete(String id) {
		try {
			ordenEmergenciaService.Delete(id);
			logger.info("Orden eliminada");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar orden", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
