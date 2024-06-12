package uni.sfw.sogepac_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.sfw.sogepac_backend.Model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String>{
	
}
