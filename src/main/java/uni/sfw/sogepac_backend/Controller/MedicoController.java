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
import uni.sfw.sogepac_backend.Model.Medico;
import uni.sfw.sogepac_backend.Service.MedicoService;

@RestController
@RequestMapping("/api/v1/Medico")
public class MedicoController {
	private Logger logger = (Logger) LoggerFactory.getLogger(MedicoController.class);
	
	@Autowired
	MedicoService medicoService;

	@GetMapping("/all")
	public ResponseEntity<List<Medico>> GetAll() {
		List<Medico> medicos = null;

		try {
			medicos = medicoService.GetAll();
			logger.info("Medicos encontrados");
			return ResponseEntity.ok(medicos);
		} 
		catch (Exception e) {
			logger.error("Error al buscar medicos", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/get")
	public ResponseEntity<Medico> GetById(String id) {
		Medico medico = null;

		try {
			medico = medicoService.GetById(id);
			logger.info("Medico encontrado");
			return ResponseEntity.ok(medico);
		} 
		catch (Exception e) {
			logger.error("Error al buscar medico", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Medico> Save(Medico medico) {
		Medico medicoSaved = null;

		try {
			medicoSaved = medicoService.Save(medico);
			logger.info("Medico guardado");
			return ResponseEntity.ok(medicoSaved);
		} 
		catch (Exception e) {
			logger.error("Error al guardar medico", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Medico> Update(Medico medico) {
		try {
			medicoService.Save(medico);
			logger.info("Medico actualizado");
			return ResponseEntity.ok(medico);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar medico", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<Void> Delete(String id) {
		try {
			medicoService.Delete(id);
			logger.info("Medico eliminado");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar medico", e);
			return ResponseEntity.internalServerError().build();
		}
	}

}
