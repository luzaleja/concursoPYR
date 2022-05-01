package concurso.programa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import concurso.dao.impl.CategoriaDaoImpl;
import concurso.dao.impl.JuegosDaoImpl;
import concurso.dao.impl.PreguntaDaoImpl;
import concurso.dao.impl.PuntosDaoImpl;
import concurso.dao.impl.RespuestaDaoImpl;
import concurso.entity.Categoria;
import concurso.entity.Juegos;
import concurso.entity.Pregunta;
import concurso.entity.Puntos;
import concurso.entity.Respuesta;
import concurso.exceptions.GenericException;
import consurso.dao.CategoriaDao;
import consurso.dao.JuegosDao;
import consurso.dao.PreguntaDao;
import consurso.dao.PuntosDao;
import consurso.dao.RespuestaDao;

public class OpcionesJuego {

	private static PreguntaDao pregDao = new PreguntaDaoImpl();
	private static CategoriaDao catDao = new CategoriaDaoImpl();
	private static RespuestaDao rtaDao = new RespuestaDaoImpl();
	private static PuntosDao puntosDao = new PuntosDaoImpl();
	private static JuegosDao juegosDao = new JuegosDaoImpl();
	
	protected OpcionesJuego() {
		
	}
	
	public static boolean ronda(int nivel, Scanner scan) {
		
		//Pregunta
		Pregunta pregunta = escogerPregunta(nivel);
		
		//Categoria
		Categoria categoriaPregunta = traerCategoria(nivel);
		
		//Respuestas
		List<Respuesta> listaRespuestas = traerRespuestas(pregunta.getId());
		
		//Creamos un mapa de respuestas
		Map<Integer,Respuesta> mapaRespuestas = new HashMap<>();
		int clave = 1;
		for(Respuesta rta : listaRespuestas) {
			mapaRespuestas.put(clave, rta);
			clave++;
		}
		
		//Mostrar pregunta con sus respuestas
		System.out.println("------------------------");
		System.out.println("Nivel - " + nivel);
		System.out.println("Categoria - " + categoriaPregunta.getCategoria());
		System.out.println(pregunta.getPregunta());
		int numeroRta = 1;
		for(Respuesta rta: listaRespuestas) {
			System.out.println(numeroRta + " - " + rta.getRespuesta());
			numeroRta++;
		}
		System.out.println("------------------------");
		int numeroRespuestaSeleccionada = scan.nextInt();
		Respuesta respuestaSeleccionada = mapaRespuestas.get(numeroRespuestaSeleccionada);
		
		//Revisar si la respuesta es correcta
		boolean correcto = revisarRespuesta(respuestaSeleccionada);
		
		return correcto;
		
	}
	
	private static Pregunta escogerPregunta(int nivel) {
		
		//nivel == categoria_id
		//Traemos las preguntas posibles del nivel
		
		List<Pregunta> listPreguntas = new ArrayList<>();
		
		try {
			listPreguntas = pregDao.findAllByCategoriaId(Long.valueOf(nivel));
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al buscar las preguntas.");
		}
		
		//Escogemos la pregunta que se hara al azar
		Random randomizer = new Random();
		Pregunta pregunta = listPreguntas.get(randomizer.nextInt(listPreguntas.size()));
		
		return pregunta;
	}
	
	public static Categoria traerCategoria(int nivel) {
		
		//nivel == id de categoria
		Categoria cat =  null;
		try {
			cat = catDao.findById(Long.valueOf(nivel));
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al buscar la categoria.");
		}
		
		return cat;
	}
	
	private static List<Respuesta> traerRespuestas(Long preguntaId) {
		
		List<Respuesta> listRespuestas = new ArrayList<>();
		
		try {
			listRespuestas = rtaDao.findAllByPreguntaId(preguntaId);
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al buscar las preguntas.");
		}
		
		return listRespuestas;
	}
	
	private static boolean revisarRespuesta(Respuesta respuestaSeleccionada) {
		
		boolean correcto = false;
		
		if(respuestaSeleccionada.getCorrecto() == 1) {
			correcto = true;
		}
		
		return correcto;
	}

	public static int encontrarPuntosGanados(int nivel) {
		
		Categoria categoriaActual = traerCategoria(nivel);
		Puntos puntosEnJuego = traerPuntosEnJuego(categoriaActual.getPuntosId());
		int puntosGanados = 0;
		if(puntosEnJuego != null) {
			puntosGanados = puntosEnJuego.getPuntosOtorgar();
		}
		
		return puntosGanados;
	}
	
	private static Puntos traerPuntosEnJuego(Long id) {
		
		Puntos puntos = null;
		try {
			puntos = puntosDao.findById(id);
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al buscar los puntos en juego.");
		}
		
		return puntos;
	}

	public static Juegos guardarPartida(Juegos juego) {
		
		Juegos partidaAGuardar = null;
		
		try {
			partidaAGuardar = juegosDao.create(juego);
		} catch (GenericException e) {
			System.err.println("Ha ocurrido un error al guardar la partida.");
		}
		
		return partidaAGuardar;
	}

}
