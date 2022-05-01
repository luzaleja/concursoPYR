package concurso.entity;

public class Respuesta {

	private Long id;
	private String respuesta;
	private Integer correcto;
	private Long preguntaId;
	
	
	public Respuesta(Long id, String respuesta, Integer correcto, Long preguntaId) {
		this.id = id;
		this.respuesta = respuesta;
		this.correcto = correcto;
		this.preguntaId = preguntaId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}


	public Integer getCorrecto() {
		return correcto;
	}


	public void setCorrecto(Integer correcto) {
		this.correcto = correcto;
	}


	public Long getPreguntaId() {
		return preguntaId;
	}


	public void setPreguntaId(Long preguntaId) {
		this.preguntaId = preguntaId;
	}


	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", respuesta=" + respuesta + ", correcto=" + correcto + ", preguntaId="
				+ preguntaId + "]";
	}
	
}
