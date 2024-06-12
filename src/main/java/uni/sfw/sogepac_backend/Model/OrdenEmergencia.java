package uni.sfw.sogepac_backend.Model;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "OrdenEmergencia")
public class OrdenEmergencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ID;
	private String historiaClinicaID;
	private String enfermeraID;
	private String medicoID;
	private String razon;
	private Date fecha;
}
