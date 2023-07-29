package br.edu.ufabc.glyphobe.ast;

public class CmdWhile extends AbstractCommand{
  private String expr;

  public CmdWhile(String language, String expr) {
    super(language);
    this.expr = expr;
  }

  @Override
  public String generateCode() {
    return "while (" + expr + ") ";
  }
}
