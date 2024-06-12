package uni.sfw.sogepac_backend.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.sfw.sogepac_backend.Model.Anfitriona;
import uni.sfw.sogepac_backend.Repository.AnfitrionaRepository;

@Service
public class AnfitrionaService{
	@Autowired
	AnfitrionaRepository anfitrionaRepository;

	public List<Anfitriona> GetAll(){
		return anfitrionaRepository.findAll();
	}

	public Anfitriona GetByID(String ID){
		return anfitrionaRepository.findById(ID).orElse(null);
	}

	public Anfitriona GetByDNI(String DNI){
		List<Anfitriona> anfitrionas = GetAll();
		for(Anfitriona anfitriona : anfitrionas){
			if(anfitriona.getDNI().equals(DNI)){
				return anfitriona;
			}
		}
		return null;
	}

	public Anfitriona Save(Anfitriona anfitriona){
		return anfitrionaRepository.save(anfitriona);
	}

	public void Delete(String ID){
		anfitrionaRepository.deleteById(ID);
	}

}
