package concurso.entity;

public class Juegos {
	
	private Long id;
	private Long jugadorId;
	private Integer puntosAcumulados;
	
	
	public Juegos() {
		
	}
	
	public Juegos(Long jugadorId) {
		this.jugadorId = jugadorId;
	}
	
	public Juegos(Long id, Long jugadorId, Integer puntosAcumulados) {
		this.id = id;
		this.jugadorId = jugadorId;
		this.puntosAcumulados = puntosAcumulados;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJugadorId() {
		return jugadorId;
	}

	public void setJugadorId(Long jugadorId) {
		this.jugadorId = jugadorId;
	}

	public Integer getPuntosAcumulados() {
		return puntosAcumulados;
	}

	public void setPuntosAcumulados(Integer puntosAcumulados) {
		this.puntosAcumulados = puntosAcumulados;
	}

	
	@Override
	public String toString() {
		return "Juegos [id=" + id + ", jugadorId=" + jugadorId + ", puntosAcumulados=" + puntosAcumulados + "]";
	}
	
}
