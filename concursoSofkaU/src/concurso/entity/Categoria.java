package concurso.entity;

public class Categoria {

	private Long id;
	private String categoria;
	private Integer nivel;
	private Long puntosId;
	
	
	public Categoria(Long id, String categoria, Integer nivel, Long puntosId) {
		this.id = id;
		this.categoria = categoria;
		this.nivel = nivel;
		this.puntosId = puntosId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Integer getNivel() {
		return nivel;
	}


	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}


	public Long getPuntosId() {
		return puntosId;
	}


	public void setPuntosId(Long puntosId) {
		this.puntosId = puntosId;
	}


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", categoria=" + categoria + ", nivel=" + nivel + ", puntosId=" + puntosId + "]";
	}
	
}
