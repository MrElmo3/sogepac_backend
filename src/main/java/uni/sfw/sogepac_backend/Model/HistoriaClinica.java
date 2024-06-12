package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "HistoriaClinica")
public class HistoriaClinica {
	@Id
	private String ID;
	private String pacienteID;
	private String enfermeraID;
}
