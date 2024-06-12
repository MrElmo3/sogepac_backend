package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

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

	@PostMapping("/add")
	public ResponseEntity<HistoriaClinica> Add(HistoriaClinica historiaClinica) {
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
	
}
