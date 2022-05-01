package concurso.programa;


public class Menu {

	public static void menuUsuario() {
		System.out.println("1. Crear usuario nuevo");
		System.out.println("2. Ya tengo usuario");
	}
	
	public static void jugarMenu() {
		System.out.println("1. Jugar una nueva partida");
		System.out.println("0. Salir");
	}
	
	public static void continuarMenu() {
		System.out.println("1. Continuar jugando");
		System.out.println("Si continuas jugando y pierdes la siguiente ronda,"
				+ " perderas los todos los puntos acumulados en el juego.");
		System.out.println("0. Salir");
		System.out.println("Si decides salir ahora, tus puntos hasta el momento"
				+ " quedarán como tus puntos ganados durante la partida.");
	}
}
