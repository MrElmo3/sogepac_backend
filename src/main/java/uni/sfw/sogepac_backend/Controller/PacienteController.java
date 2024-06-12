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
import uni.sfw.sogepac_backend.Model.Paciente;
import uni.sfw.sogepac_backend.Service.PacienteService;

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
	
	@GetMapping("/get")
	public ResponseEntity<Paciente> GetById(String id) {
		Paciente paciente = null;

		try {
			paciente = pacienteService.GetById(id);
			logger.info("Paciente encontrado");
			return ResponseEntity.ok(paciente);
		} 
		catch (Exception e) {
			logger.error("Error al buscar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Paciente> Add(Paciente paciente) {
		try {
			pacienteService.Save(paciente);
			logger.info("Paciente agregado");
			return ResponseEntity.ok(paciente);
		} 
		catch (Exception e) {
			logger.error("Error al agregar paciente", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Paciente> Update(Paciente paciente) {
		try {
			pacienteService.Save(paciente);
			logger.info("Paciente actualizado");
			return ResponseEntity.ok(paciente);
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
