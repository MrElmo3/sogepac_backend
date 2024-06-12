package uni.sfw.sogepac_backend.Model;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Cita")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ID;
	private Date fecha;
	private String historiaClinicaID;
	private String RecepcionistaID;
	private String medicoID;
}
