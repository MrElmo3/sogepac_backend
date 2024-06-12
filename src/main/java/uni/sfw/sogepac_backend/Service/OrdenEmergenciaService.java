package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.OrdenEmergencia;
import uni.sfw.sogepac_backend.Repository.OrdenEmergenciaRepository;

@Service
public class OrdenEmergenciaService {
	@Autowired
	OrdenEmergenciaRepository ordenEmergenciaRepository;

	public List<OrdenEmergencia> GetAll() {
		return ordenEmergenciaRepository.findAll();
	}

	public OrdenEmergencia GetById(String id) {
		return ordenEmergenciaRepository.findById(id).orElse(null);
	}

	public OrdenEmergencia Save(OrdenEmergencia ordenEmergencia) {
		return ordenEmergenciaRepository.save(ordenEmergencia);
	}

	public void Delete(String id) {
		ordenEmergenciaRepository.deleteById(id);
	}
}
