package uni.sfw.sogepac_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.sfw.sogepac_backend.Model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String>{

}
