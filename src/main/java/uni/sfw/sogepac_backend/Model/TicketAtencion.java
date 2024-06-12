package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TicketAtencion")
public class TicketAtencion {
	@Id
	private String ID;
	private Boolean fueAtendido;
	private String anfitrionaID;
	private String PacienteID;

}
