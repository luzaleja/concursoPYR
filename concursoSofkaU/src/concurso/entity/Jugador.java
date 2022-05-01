package concurso.entity;

public class Jugador {

	//atributos
	
	private Long id;
	private String username;
	private String nombre;
	private String apellido;

	
	//constructor
	
	public Jugador() {
		
	}
	
	public Jugador(String username, String nombre, String apellido) {
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Jugador(Long id, String username, String nombre, String apellido) {
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
	}


	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	//toString
	
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", username=" + username + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
