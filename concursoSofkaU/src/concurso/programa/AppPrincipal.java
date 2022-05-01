package concurso.programa;

import java.util.Scanner;

import concurso.entity.Juegos;
import concurso.entity.Jugador;

public class AppPrincipal {

	public static void main(String[] args) {

		System.out.println("¡Bienvenido al concurso de preguntas y respuestas!");
		
		Scanner scan = new Scanner(System.in);
		
		//JUGADOR
		
		Jugador jugador = null;
		
		while(jugador == null) {
			int opUsuario;
			do {
				Menu.menuUsuario();
				opUsuario = scan.nextInt();
			} while(opUsuario != 1 && opUsuario != 2);
			
			if (opUsuario == 1) {
				jugador = OpcionesJugador.crearUsuario(scan);
			} else {
				jugador = OpcionesJugador.ingresarUsuario(scan);
				if (jugador == null) {
					System.err.println("El usuario no existe.");
				}
			}
		}
		
		System.out.println("------------------------");
		System.out.println("USUARIO:");
		System.out.println(jugador);
		System.out.println("------------------------");
		
		
		//JUEGO
		
		int opJuegoMenu;
		Juegos juegoEnCurso = new Juegos(jugador.getId());
		
		do {
			Menu.jugarMenu();
			opJuegoMenu = scan.nextInt();
		} while (opJuegoMenu != 1 && opJuegoMenu != 0);
		
		if (opJuegoMenu == 1) {
			//Empezar rondas
			int nivel = 1;
			int puntosAcumulados = 0;
			boolean continuar = true;
			
			while(nivel <= 5 && continuar) {
				boolean rondaGanada = OpcionesJuego.ronda(nivel, scan);
				//si gana la ronda busco los puntos ganados y los sumoo
				//y le pregunto si quiere continuar a la siguiente ronda
				if(rondaGanada) {
					int puntosGanados = OpcionesJuego.encontrarPuntosGanados(nivel);
					puntosAcumulados += puntosGanados;
					System.out.println("Has ganado " + puntosGanados + " puntos.");
					
					if(nivel == 5) {
						System.out.println("¡Haz ganado la partida!");
						juegoEnCurso.setPuntosAcumulados(puntosAcumulados);
						Juegos juegoGuardado = OpcionesJuego.guardarPartida(juegoEnCurso);
						System.out.println("Ganaste " + puntosAcumulados + " puntos.");
						System.out.println("La partida ha sido guardada: " + juegoGuardado);
						System.exit(0);
					}
					nivel++;
					
					int opContinuar;
					do {
						Menu.continuarMenu();
						opContinuar = scan.nextInt();
					} while(opContinuar != 1 && opContinuar != 0);
					
					if(opContinuar == 1) {
						System.out.println("Has decidido continuar.");
					} else {
						//si no decide continuar, guardo la partida en el historico
						juegoEnCurso.setPuntosAcumulados(puntosAcumulados);
						Juegos juegoGuardado = OpcionesJuego.guardarPartida(juegoEnCurso);
						
						System.out.println("El juego ha terminado y se ha guardado la partida.");
						System.out.println("Partida guardada: " + juegoGuardado);
						
						continuar = false;
					}
				} else {
					//si ha perdido la ronda
					puntosAcumulados = 0;
					
					//guardamos la partida
					juegoEnCurso.setPuntosAcumulados(puntosAcumulados);
					Juegos juegoGuardado = OpcionesJuego.guardarPartida(juegoEnCurso);
					
					System.out.println("La respuesta es incorrecta. El juego ha terminado.");
					System.out.println("Se ha guardado la partida: " + juegoGuardado);
					
					continuar = false;
				}
			}
		} else {
			System.out.println("Saliendo de la aplicación.");
			System.exit(0);
		}
	}
}
