package uni.sfw.sogepac_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Recepcionista")
public class Recepcionista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ID;
	private String nombre;
	private String DNI;
	private int edad;
}
