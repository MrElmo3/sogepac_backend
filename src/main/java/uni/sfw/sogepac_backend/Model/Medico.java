package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "medico")
public class Medico {
	private String id;
	private String nombre;
	private String DNI;
	private String telefono;
}
