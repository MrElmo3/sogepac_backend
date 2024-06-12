package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.Paciente;
import uni.sfw.sogepac_backend.Repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;

	public List<Paciente> GetAll() {
		return pacienteRepository.findAll();
	}

	public Paciente GetById(String id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	public void Save(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	public void Delete(String id) {
		pacienteRepository.deleteById(id);
	}
	
}
