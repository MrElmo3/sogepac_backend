package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.Recepcionista;
import uni.sfw.sogepac_backend.Repository.RecepcionistaRepository;

@Service
public class RecepcionistaService {
	@Autowired
	RecepcionistaRepository recepcionistaRepository;

	public List<Recepcionista> GetAll() {
		return recepcionistaRepository.findAll();
	}

	public Recepcionista GetById(String id) {
		return recepcionistaRepository.findById(id).orElse(null);
	}

	public Recepcionista GetByDNI(String DNI) {
		List<Recepcionista> recepcionistas = recepcionistaRepository.findAll();
		for (Recepcionista recepcionista : recepcionistas) {
			if (recepcionista.getDNI().equals(DNI)) {
				return recepcionista;
			}
		}
		return null;
	}

	public Recepcionista Save(Recepcionista recepcionista) {
		return recepcionistaRepository.save(recepcionista);
	}

	public void Delete(String id) {
		recepcionistaRepository.deleteById(id);
	}
}
