package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Model.Anfitriona;
import uni.sfw.sogepac_backend.Service.AnfitrionaService;

@RestController
@RequestMapping("/api/v1/Anfitriona")
public class AnfitrionaController {
	Logger logger = (Logger) LoggerFactory.getLogger(AnfitrionaController.class);

	@Autowired
	AnfitrionaService anfitrionaService;

	@GetMapping("/all")
	public ResponseEntity<List<Anfitriona>> GetAll() {
		List<Anfitriona> anfitrionas = null;

		try {
			anfitrionas = anfitrionaService.GetAll();
			logger.info("Anfitrionas encontradas");
			return ResponseEntity.ok(anfitrionas);
		} 
		catch (Exception e) {
			logger.error("Error al buscar anfitrionas", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getID")
	public ResponseEntity<Anfitriona> GetById(String id) {
		Anfitriona anfitriona = null;

		try {
			anfitriona = anfitrionaService.GetByID(id);
			if (anfitriona == null) {
				logger.info("Anfitriona no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Anfitriona encontrada");
			return ResponseEntity.ok(anfitriona);
		} 
		catch (Exception e) {
			logger.error("Error al buscar anfitriona", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getDNI")
	public ResponseEntity<Anfitriona> GetByDNI(String DNI) {
		Anfitriona anfitriona = null;

		try {
			anfitriona = anfitrionaService.GetByDNI(DNI);
			if (anfitriona == null) {
				logger.info("Anfitriona no encontrada");
				return ResponseEntity.notFound().build();
			}
			logger.info("Anfitriona encontrada");
			return ResponseEntity.ok(anfitriona);
		} 
		catch (Exception e) {
			logger.error("Error al buscar anfitriona", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Anfitriona> Add(@RequestBody Anfitriona anfitriona) {
		Anfitriona anfitrionaAdded = null;

		try {
			anfitrionaAdded = anfitrionaService.Save(anfitriona);
			logger.info("Anfitriona agregada");
			return ResponseEntity.ok(anfitrionaAdded);
		} 
		catch (Exception e) {
			logger.error("Error al agregar anfitriona", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Anfitriona> Update(@RequestBody Anfitriona anfitriona) {
		Anfitriona anfitrionaUpdated = null;

		try {
			anfitrionaUpdated = anfitrionaService.Save(anfitriona);
			logger.info("Anfitriona actualizada");
			return ResponseEntity.ok(anfitrionaUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar anfitriona", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Anfitriona> Delete(@RequestBody String id) {
		try {
			anfitrionaService.Delete(id);
			logger.info("Anfitriona eliminada");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar anfitriona", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
