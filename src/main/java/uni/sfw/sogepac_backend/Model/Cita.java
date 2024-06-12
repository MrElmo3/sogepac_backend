package uni.sfw.sogepac_backend.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Cita")
public class Cita {
	@Id
	private String ID;
	private Date fecha;
	private String historiaClinicaID;
	private String RecepcionistaID;
	private String medicoID;
}
