package uni.sfw.sogepac_backend.Model;

import java.sql.Date;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "OrdenEmergencia")
public class OrdenEmergencia {
	private String id;
	private String historiaClinicaID;
	private String enfermeraID;
	private String razon;
	private Date fecha;
}
