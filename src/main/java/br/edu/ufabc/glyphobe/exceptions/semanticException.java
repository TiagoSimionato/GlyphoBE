package br.edu.ufabc.glyphobe.exceptions;

public class semanticException extends RuntimeException {
  public semanticException(String msg) {
    super("Semantic error - " + msg);
  }
}
