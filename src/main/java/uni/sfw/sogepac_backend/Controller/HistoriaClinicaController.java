package uni.sfw.sogepac_backend.Controller;

import java.util.List;


import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Service.HistoriaClinicaService;
import uni.sfw.sogepac_backend.Model.HistoriaClinica;

@RestController
@RequestMapping("/api/v1/HistoriaClinica")
public class HistoriaClinicaController {
	private Logger logger = (Logger) LoggerFactory.getLogger(EnfermeraController.class);

	@Autowired
	HistoriaClinicaService historiaClinicaService;

	@GetMapping("/all")
	public ResponseEntity<List<HistoriaClinica>> GetAll() {
		List<HistoriaClinica> historiaClinica = null;

		try {
			historiaClinica = historiaClinicaService.GetAll();
			logger.info("Historia Clinica encontrada");
			return ResponseEntity.ok(historiaClinica);
		} 
		catch (Exception e) {
			logger.error("Error al buscar Historia Clinica", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getID")
	public ResponseEntity<HistoriaClinica> GetById(String id) {
		HistoriaClinica historiaClinica = null;

		try {
			historiaClinica = historiaClinicaService.GetById(id);
			if(historiaClinica == null) {
				logger.info("Historia Clinica no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Historia Clinica encontrada");
			return ResponseEntity.ok(historiaClinica);
		} 
		catch (Exception e) {
			logger.error("Error al buscar Historia Clinica", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<HistoriaClinica> Add(@RequestBody HistoriaClinica historiaClinica) {
		HistoriaClinica historiaClinicaAdded = null;

		try {
			historiaClinicaAdded = historiaClinicaService.Save(historiaClinica);
			logger.info("Historia Clinica agregada");
			return ResponseEntity.ok(historiaClinicaAdded);
		} 
		catch (Exception e) {
			logger.error("Error al agregar Historia Clinica", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<HistoriaClinica> Update(@RequestBody HistoriaClinica historiaClinica) {
		HistoriaClinica historiaClinicaUpdated = null;

		try {
			historiaClinicaUpdated = historiaClinicaService.Save(historiaClinica);
			logger.info("Historia Clinica actualizada");
			return ResponseEntity.ok(historiaClinicaUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar Historia Clinica", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<HistoriaClinica> Delete(@RequestBody String id) {
		try {
			historiaClinicaService.Delete(id);
			logger.info("Historia Clinica eliminada");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar Historia Clinica", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
