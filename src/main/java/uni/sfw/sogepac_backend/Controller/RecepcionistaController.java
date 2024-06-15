package uni.sfw.sogepac_backend.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.sfw.sogepac_backend.Model.Recepcionista;
import uni.sfw.sogepac_backend.Service.RecepcionistaService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/Recepcionista")
public class RecepcionistaController {
	private Logger logger = (Logger) LoggerFactory.getLogger(RecepcionistaController.class);

	@Autowired
	RecepcionistaService recepcionistaService;

	@GetMapping("/all")
	public ResponseEntity<List<Recepcionista>> GetAll() {
		List<Recepcionista> recepcionistas = null;

		try {
			recepcionistas = recepcionistaService.GetAll();
			logger.info("Recepcionistas encontrados");
			return ResponseEntity.ok(recepcionistas);
		} 
		catch (Exception e) {
			logger.error("Error al buscar recepcionistas", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getID")
	public ResponseEntity<Recepcionista> GetById(String id) {
		Recepcionista recepcionista = null;

		try {
			recepcionista = recepcionistaService.GetById(id);
			if(recepcionista == null) {
				logger.info("Recepcionista no encontrado");
				return ResponseEntity.notFound().build();
			}
			logger.info("Recepcionista encontrado");
			return ResponseEntity.ok(recepcionista);
		} 
		catch (Exception e) {
			logger.error("Error al buscar recepcionista", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/getDNI")
	public ResponseEntity<Recepcionista> GetByDNI(String DNI) {
		Recepcionista recepcionista = null;

		try {
			recepcionista = recepcionistaService.GetByDNI(DNI);
			if(recepcionista == null) {
				logger.info("Recepcionista no encontrado");
				return ResponseEntity.notFound().build();
			}
			logger.info("Recepcionista encontrado");
			return ResponseEntity.ok(recepcionista);
		} 
		catch (Exception e) {
			logger.error("Error al buscar recepcionista", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Recepcionista> Add(@RequestBody Recepcionista recepcionista) {
		Recepcionista recepcionistaAdded = null;

		try {
			recepcionistaAdded = recepcionistaService.Save(recepcionista);
			logger.info("Recepcionista agregado");
			return ResponseEntity.ok(recepcionistaAdded);
		} 
		catch (Exception e) {
			logger.error("Error al agregar recepcionista", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Recepcionista> Update(@RequestBody Recepcionista recepcionista) {
		Recepcionista recepcionistaUpdated = null;

		try {
			recepcionistaUpdated = recepcionistaService.Save(recepcionista);
			logger.info("Recepcionista actualizado");
			return ResponseEntity.ok(recepcionistaUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar recepcionista", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<Void> Delete(String id) {
		try {
			recepcionistaService.Delete(id);
			logger.info("Recepcionista eliminado");
			return ResponseEntity.ok().build();
		} 
		catch (Exception e) {
			logger.error("Error al eliminar recepcionista", e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}