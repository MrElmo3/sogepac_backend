package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Medico")
public class Medico {
	@Id
	private String ID;
	private String nombre;
	private String DNI;
	private String telefono;
}
