package br.edu.ufabc.glyphobe.ast;

public class CmdWhile extends AbstractCommand{
  private String expr;

  public CmdWhile(String language, String expr) {
    super(language);
    this.expr = expr;
  }

  @Override
  public String generateCode() {
    switch(language) {
      case "py":
        return "while (" + expr + ")";
      default: /*js, java */
        return "while (" + expr + ") ";
    }
  }
}
