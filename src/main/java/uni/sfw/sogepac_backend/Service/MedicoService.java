package uni.sfw.sogepac_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.Medico;
import uni.sfw.sogepac_backend.Repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	MedicoRepository medicoRepository;

	public List<Medico> GetAll() {
		return medicoRepository.findAll();
	}

	public Medico GetById(String id) {
		return medicoRepository.findById(id).orElse(null);
	}

	public Medico Save(Medico medico) {
		return medicoRepository.save(medico);
	}

	public void Delete(String id) {
		medicoRepository.deleteById(id);
	}
}
