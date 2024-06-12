package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Model.Enfermera;
import uni.sfw.sogepac_backend.Service.EnfermeraService;

@RestController
@RequestMapping("api/v1/enfermera")
public class EnfermeraController {
	private Logger logger = (Logger) LoggerFactory.getLogger(EnfermeraController.class);

	@Autowired
	EnfermeraService enfermeraService;

	@GetMapping("/all")
	public ResponseEntity<List<Enfermera>> GetAll() {
		List<Enfermera> enfermeras = null;

		try {
			enfermeras = enfermeraService.GetAll();
			logger.info("Enfermeras encontradas");
			return ResponseEntity.ok(enfermeras);
		} 
		catch (Exception e) {
			logger.error("Error al buscar enfermeras", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getID")
	public ResponseEntity<Enfermera> GetById(String id) {
		Enfermera enfermera = null;

		try {
			enfermera = enfermeraService.GetById(id);
			if(enfermera == null) {
				logger.info("Enfermera no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Enfermera encontrada");
			return ResponseEntity.ok(enfermera);
		} 
		catch (Exception e) {
			logger.error("Error al buscar enfermera", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getDNI")
	public ResponseEntity<Enfermera> GetByDNI(String DNI) {
		Enfermera enfermera = null;

		try {
			enfermera = enfermeraService.GetByDNI(DNI);
			if (enfermera == null) {
				logger.info("Enfermera no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Enfermera encontrada");
			return ResponseEntity.ok(enfermera);
		} 
		catch (Exception e) {
			logger.error("Error al buscar enfermera", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Enfermera> Add(@RequestBody Enfermera enfermera) {
		Enfermera enfermeraAdded = null;

		try {
			enfermeraAdded = enfermeraService.Save(enfermera);
			logger.info("Enfermera agregada");
			return ResponseEntity.ok(enfermeraAdded);
		} 
		catch (Exception e) {
			logger.error("Error al agregar enfermera", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Enfermera> Update(@RequestBody Enfermera enfermera) {
		Enfermera enfermeraUpdated = null;

		try {
			enfermeraUpdated = enfermeraService.Save(enfermera);
			logger.info("Enfermera actualizada");
			return ResponseEntity.ok(enfermeraUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar enfermera", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<Enfermera> Delete(String id) {
		try {
			enfermeraService.Delete(id);
			logger.info("Enfermera eliminada");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar enfermera", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
