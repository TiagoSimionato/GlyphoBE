package src.exceptions;

public class semanticException extends RuntimeException {
  public semanticException(String msg) {
    super("Semantic error - " + msg);
  }
}
