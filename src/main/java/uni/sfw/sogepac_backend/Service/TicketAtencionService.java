package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.TicketAtencion;
import uni.sfw.sogepac_backend.Repository.TicketAtencionRepository;

@Service
public class TicketAtencionService {
	@Autowired
	TicketAtencionRepository ticketAtencionRepository;

	public List<TicketAtencion> GetAll() {
		return ticketAtencionRepository.findAll();
	}

	public TicketAtencion GetById(String id) {
		return ticketAtencionRepository.findById(id).orElse(null);
	}

	public TicketAtencion Save(TicketAtencion ticketAtencion) {
		return ticketAtencionRepository.save(ticketAtencion);
	}

	public void Delete(String id) {
		ticketAtencionRepository.deleteById(id);
	}
}
