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

import uni.sfw.sogepac_backend.Model.TicketAtencion;
import uni.sfw.sogepac_backend.Service.TicketAtencionService;

@RestController
@RequestMapping("/api/v1/TicketAtencion")
public class TicketAtencionController {
	private Logger logger = (Logger) LoggerFactory.getLogger(EnfermeraController.class);

	@Autowired
	TicketAtencionService ticketAtencionService;

	@GetMapping("/all")
	public ResponseEntity<List<TicketAtencion>> GetAll() {
		List<TicketAtencion> tickets = null;

		try {
			tickets = ticketAtencionService.GetAll();
			logger.info("Tickets encontrados");
			return ResponseEntity.ok(tickets);
		} 
		catch (Exception e) {
			logger.error("Error al buscar tickets", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	private ResponseEntity<TicketAtencion> Add(TicketAtencion ticket) {
		TicketAtencion ticketAdded = null;

		try {
			ticketAdded = ticketAtencionService.Save(ticket);
			logger.info("Ticket agregado");
			return ResponseEntity.ok(ticketAdded);
		} 
		catch (Exception e) {
			logger.error("Error al agregar ticket", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/update")
	public ResponseEntity<TicketAtencion> Update(@RequestBody TicketAtencion ticket) {
		TicketAtencion ticketUpdated = null;

		try {
			ticketUpdated = ticketAtencionService.Save(ticket);
			logger.info("Ticket actualizado");
			return ResponseEntity.ok(ticketUpdated);
		} 
		catch (Exception e) {
			logger.error("Error al actualizar ticket", e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<String> Delete(String id) {
		try {
			ticketAtencionService.Delete(id);
			logger.info("Ticket eliminado");
			return ResponseEntity.ok("Ticket eliminado");
		} 
		catch (Exception e) {
			logger.error("Error al eliminar ticket", e);
			return ResponseEntity.internalServerError().build();
		}
	}
}
