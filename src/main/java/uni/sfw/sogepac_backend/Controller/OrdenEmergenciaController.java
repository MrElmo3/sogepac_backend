package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import uni.sfw.sogepac_backend.Model.OrdenEmergencia;
import uni.sfw.sogepac_backend.Service.OrdenEmergenciaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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

	@GetMapping("/get")
	public ResponseEntity<OrdenEmergencia> GetById(String id) {
		OrdenEmergencia orden = null;

		try {
			orden = ordenEmergenciaService.GetById(id);
			logger.info("Orden encontrada");
			return ResponseEntity.ok(orden);
		} 
		catch (Exception e) {
			logger.error("Error al buscar orden", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<OrdenEmergencia> Save(OrdenEmergencia orden) {
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
	
}
