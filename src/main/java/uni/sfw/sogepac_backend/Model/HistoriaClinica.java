package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "HistoriaClinica")
public class HistoriaClinica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ID;
	private String pacienteID;
	private String enfermeraID;
}
