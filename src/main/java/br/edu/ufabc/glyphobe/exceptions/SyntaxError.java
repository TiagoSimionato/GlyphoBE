package br.edu.ufabc.glyphobe.exceptions;

public class SyntaxError extends RuntimeException {
  public SyntaxError(String msg) {
    super("Syntax error - " + msg);
  }
}
