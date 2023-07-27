package br.edu.ufabc.glyphobe.ast;

public abstract class AbstractCommand {
  public abstract String generateCode();
  public abstract void run();
}
