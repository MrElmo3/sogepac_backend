package uni.sfw.sogepac_backend.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "OrdenEmergencia")
public class OrdenEmergencia {
	@Id
	private String ID;
	private String historiaClinicaID;
	private String enfermeraID;
	private String medicoID;
	private String razon;
	private Date fecha;
}
