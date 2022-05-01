package concurso.entity;

public class Puntos {

	private Long id;
	private Integer puntosOtorgar;
	
	
	public Puntos(Long id, Integer puntosOtorgar) {
		this.id = id;
		this.puntosOtorgar = puntosOtorgar;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getPuntosOtorgar() {
		return puntosOtorgar;
	}


	public void setPuntosOtorgar(Integer puntosOtorgar) {
		this.puntosOtorgar = puntosOtorgar;
	}


	@Override
	public String toString() {
		return "Puntos [id=" + id + ", puntosOtorgar=" + puntosOtorgar + "]";
	}
	
}
