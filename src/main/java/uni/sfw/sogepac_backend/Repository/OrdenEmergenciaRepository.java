package uni.sfw.sogepac_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.sfw.sogepac_backend.Model.OrdenEmergencia;

@Repository
public interface OrdenEmergenciaRepository extends JpaRepository<OrdenEmergencia, String>{
	
}
