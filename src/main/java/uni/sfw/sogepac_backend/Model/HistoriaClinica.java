package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "HistoriaClinica")
public class HistoriaClinica {
	private String ID;
	private String pacienteID;
	private String enfermeraID;
}
