package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.Enfermera;
import uni.sfw.sogepac_backend.Repository.EnfermeraRepository;

@Service
public class EnfermeraService {
	@Autowired
	EnfermeraRepository enfermeraRepository;

	public List<Enfermera> GetAll() {
		return enfermeraRepository.findAll();
	}

	public Enfermera GetById(String id) {
		return enfermeraRepository.findById(id).orElse(null);
	}

	public void Save(Enfermera enfermera) {
		enfermeraRepository.save(enfermera);
	}

	public void Delete(String id) {
		enfermeraRepository.deleteById(id);
	}
}
