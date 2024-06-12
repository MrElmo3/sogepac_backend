package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Model.Cita;
import uni.sfw.sogepac_backend.Service.CitaService;

@RestController
@RequestMapping("api/v1/Cita")
public class CitaController {
	private Logger logger = (Logger) LoggerFactory.getLogger(CitaController.class);

	@Autowired
	CitaService citaService;

	@GetMapping("/all")
	public ResponseEntity<List<Cita>> GetAll() {
		List<Cita> citas = null;

		try {
			citas = citaService.GetAll();
			logger.info("Citas encontradas");
			return ResponseEntity.ok(citas);
		} 
		catch (Exception e) {
			logger.error("Error al buscar citas", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getID")
	public ResponseEntity<Cita> GetById(String id) {
		Cita cita = null;

		try {
			cita = citaService.GetById(id);
			if(cita == null) {
				logger.info("Cita no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Cita encontrada");
			return ResponseEntity.ok(cita);
		} 
		catch (Exception e) {
			logger.error("Error al buscar cita", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Cita> Add(@RequestBody Cita cita) {
		Cita citaSaved = null;

		try {
			citaSaved = citaService.Save(cita);
			logger.info("Cita guardada");
			return ResponseEntity.ok(citaSaved);
		} 
		catch (Exception e) {
			logger.error("Error al guardar cita", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Cita> Update(@RequestBody Cita cita) {
		Cita citaUpdated = null;

		try {
			citaUpdated = citaService.Save(cita);
			logger.info("Cita actualizada");
			return ResponseEntity.ok(citaUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar cita", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> Delete(@RequestBody String id) {
		try {
			citaService.Delete(id);
			logger.info("Cita eliminada");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar cita", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}