package concurso.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import concurso.conexion.AdministradorDeConexiones;
import concurso.entity.Categoria;
import concurso.exceptions.GenericException;
import consurso.dao.CategoriaDao;

public class CategoriaDaoImpl implements CategoriaDao {

	@Override
	public Categoria findById(Long id) throws GenericException {
		
		Categoria categoria = null;
		
		String sql = "SELECT * FROM categoria WHERE id = " + id;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					while(res.next()) {
						String categoriaStr = res.getString(2);
						Integer nivel = res.getInt(3);
						Long puntosId = res.getLong(4);
						categoria = new Categoria(id,categoriaStr,nivel,puntosId);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql,e);
		}
		
		return categoria;
	}

	
}
