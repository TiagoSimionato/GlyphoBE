package br.edu.ufabc.glyphobe.exceptions;

public class SemanticError extends RuntimeException {
  public SemanticError(String msg) {
    super("Semantic error - " + msg);
  }
}
