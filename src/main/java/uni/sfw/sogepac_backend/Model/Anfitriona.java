package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Anfitriona")
public class Anfitriona {
	@Id
	private String ID;
	private String nombre;
	private String DNI;
	private int edad;
}
