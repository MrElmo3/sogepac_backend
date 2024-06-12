package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.Cita;
import uni.sfw.sogepac_backend.Repository.CitaRepository;

@Service
public class CitaService {
	@Autowired
	CitaRepository citaRepository;

	public List<Cita> GetAll() {
		return citaRepository.findAll();
	}

	public Cita GetById(String id) {
		return citaRepository.findById(id).orElse(null);
	}

	public Cita Save(Cita cita) {
		return citaRepository.save(cita);
	}

	public void Delete(String id) {
		citaRepository.deleteById(id);
	}
}
