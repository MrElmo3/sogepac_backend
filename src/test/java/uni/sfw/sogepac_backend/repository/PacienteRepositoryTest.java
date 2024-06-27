package uni.sfw.sogepac_backend.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import uni.sfw.sogepac_backend.Model.Paciente;
import uni.sfw.sogepac_backend.Repository.PacienteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PacienteRepositoryTest {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void PacienteRepository_Listar() {
        Paciente paciente1 = Paciente.builder().ID("13").nombre("PacienteTest").DNI("11223344").edad(20)
                .telefono("999888777")
                .build();

        Paciente paciente2 = Paciente.builder().ID("14").nombre("PacienteTest2").DNI("55667788").edad(21)
                .telefono("666555444")
                .build();

        pacienteRepository.save(paciente1);
        pacienteRepository.save(paciente2);

        List<Paciente> pacienteList = (List<Paciente>) pacienteRepository.findAll();
        Assertions.assertThat(pacienteList).isNotNull();
        Assertions.assertThat(pacienteList.size()).isEqualTo(2);
    }

    @Test
    public void PacienteRepository_Insert() {
        Paciente paciente1 = Paciente.builder().ID("13").nombre("PacienteTest").DNI("11223344").edad(20)
                .telefono("999888777")
                .build();
        
        Paciente newPaciente = pacienteRepository.save(paciente1);

        Assertions.assertThat(newPaciente).isNotNull();
    }

}
