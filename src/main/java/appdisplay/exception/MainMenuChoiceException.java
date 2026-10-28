package appdisplay.exception;

public class MainMenuChoiceException extends RuntimeException {
    public MainMenuChoiceException() {
        super("Le choix doit être un entier entre 0 et 4");
    }
}
