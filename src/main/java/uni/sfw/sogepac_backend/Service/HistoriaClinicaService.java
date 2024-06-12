package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.HistoriaClinica;
import uni.sfw.sogepac_backend.Repository.HistoriaClinicaRepository;

@Service
public class HistoriaClinicaService {
	@Autowired
	HistoriaClinicaRepository historiaClinicaRepository;

	public List<HistoriaClinica> GetAll() {
		return historiaClinicaRepository.findAll();
	}

	public HistoriaClinica GetById(String id) {
		return historiaClinicaRepository.findById(id).orElse(null);
	}

	public HistoriaClinica Save(HistoriaClinica historiaClinica) {
		return historiaClinicaRepository.save(historiaClinica);
	}

	public void Delete(String id) {
		historiaClinicaRepository.deleteById(id);
	}

}
