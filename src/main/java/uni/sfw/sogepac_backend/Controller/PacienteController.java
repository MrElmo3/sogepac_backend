package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Model.Paciente;
import uni.sfw.sogepac_backend.Service.PacienteService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/v1/paciente")
public class PacienteController {
	private Logger logger = (Logger) LoggerFactory.getLogger(PacienteController.class);

	@Autowired
	PacienteService pacienteService;

	@GetMapping("/all")
	public ResponseEntity<List<Paciente>> GetAll() {
		List<Paciente> pacientes = null;

		try {
			pacientes = pacienteService.GetAll();
			logger.info("Pacientes encontrados");
			return ResponseEntity.ok(pacientes);
		} 
		catch (Exception e) {
			logger.error("Error al buscar pacientes", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/getID")
	public ResponseEntity<Paciente> GetById(String id) {
		Paciente paciente = null;

		try {
			paciente = pacienteService.GetById(id);
			if(paciente == null) {
				logger.info("Paciente no encontrado");
				return ResponseEntity.notFound().build();
			}
			logger.info("Paciente encontrado");
			return ResponseEntity.ok(paciente);
		} 
		catch (Exception e) {
			logger.error("Error al buscar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getDNI")
	public ResponseEntity<Paciente> GetByDNI(String DNI) {
		Paciente paciente = null;

		try {
			paciente = pacienteService.GetByDNI(DNI);
			if(paciente == null) {
				logger.info("Paciente no encontrado");
				return ResponseEntity.notFound().build();
			}
			logger.info("Paciente encontrado");
			return ResponseEntity.ok(paciente);
		} 
		catch (Exception e) {
			logger.error("Error al buscar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Paciente> Add(@RequestBody Paciente paciente) {
		Paciente pacienteAdded = null;

		try {
			pacienteAdded = pacienteService.Save(paciente);
			logger.info("Paciente agregado");
			return ResponseEntity.ok(pacienteAdded);
		} 
		catch (Exception e) {
			logger.error("Error al agregar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Paciente> Update(@RequestBody Paciente paciente) {
		Paciente pacienteUpdate = null;

		try {
			pacienteUpdate = pacienteService.Save(paciente);
			logger.info("Paciente actualizado");
			return ResponseEntity.ok(pacienteUpdate);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<Paciente> Delete(String id) {
		try {
			pacienteService.Delete(id);
			logger.info("Paciente eliminado");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}
}
