package concurso.exceptions;

public class GenericException extends Exception {

	public GenericException(String msj) {
		super(msj);
	}

	public GenericException(String msj, Throwable cause) {
		super(msj, cause);
	}
}
