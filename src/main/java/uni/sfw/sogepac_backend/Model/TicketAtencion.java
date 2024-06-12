package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "TicketAtencion")
public class TicketAtencion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ID;
	private Boolean fueAtendido;
	private String anfitrionaID;
	private String PacienteID;

}
