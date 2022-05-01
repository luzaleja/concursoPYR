package concurso.programa;

import java.util.Scanner;

import concurso.dao.impl.JugadorDaoImpl;
import concurso.entity.Jugador;
import concurso.exceptions.GenericException;
import consurso.dao.JugadorDao;

public class OpcionesJugador {

	private static JugadorDao jDao = new JugadorDaoImpl();
	
	private OpcionesJugador() {
		
	}
	
	private static Jugador crearUsuarioDatos(Scanner scan) {
		System.out.println("------------------------");
		System.out.println("CREAR USUARIO");
		System.out.println("------------------------");
		//Pedimos los datos 
		System.out.println("Ingrese el usuario: ");
		String username = scan.next();
		System.out.println("Ingrese su nombre: ");
		String nombre = scan.next();
		System.out.println("Ingrese su apellido: ");
		String apellido = scan.next();
		
		return new Jugador(username,nombre,apellido);
	}
	
	private static String solicitarUsuario(Scanner scan) {
		System.out.println("------------------------");
		System.out.println("YA TENGO USUARIO");
		System.out.println("------------------------");
		//Pedimos el usuario
		System.out.println("Ingrese su usuario: ");
		String username = scan.next();
		
		return username;
	}
	
	public static Jugador crearUsuario(Scanner scan) {
		
		//Pedimos los datos y guardamos temporalmente
		Jugador jugadorTemp = crearUsuarioDatos(scan);
		
		//Intentamos crear el usuario
		
		Jugador jugadorCreado = null;
		
		try {
			jugadorCreado = jDao.create(jugadorTemp);
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al crear el usuario.");
		}
		
		return jugadorCreado;
	}
	
	public static Jugador ingresarUsuario(Scanner scan) {
		
		//Pedimos el usuario y lo buscamos
		String usuarioTemp = solicitarUsuario(scan);
		
		Jugador jugador = null; 
		
		try {
			jugador = jDao.findByUsername(usuarioTemp);
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al buscar el usuario.");
		}

		return jugador;
	}
}
