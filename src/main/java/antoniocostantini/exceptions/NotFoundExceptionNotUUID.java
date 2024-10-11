package antoniocostantini.exceptions;

public class NotFoundExceptionNotUUID extends RuntimeException {
	public NotFoundExceptionNotUUID(Long id) {
		super("Il record con id " + id + " non è stato trovato");
	}
}
