package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Enfermera")
public class Enfermera {
	@Id
	private String id;
	private String nombre;
	private String DNI;
	private int edad;
}
