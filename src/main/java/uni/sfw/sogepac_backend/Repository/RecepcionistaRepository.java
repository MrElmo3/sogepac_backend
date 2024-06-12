package uni.sfw.sogepac_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.sfw.sogepac_backend.Model.Recepcionista;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, String>{
	
}
