package br.edu.ufabc.glyphobe.ast;

public class CmdIf extends AbstractCommand {
  private int type;
  private String expr;

  public CmdIf(String language, int type, String expr) {
    super(language);
    this.type = type;
    this.expr = expr;
  }

  @Override
  public String generateCode() {
    if (type == 1) return generateIf();
    if (type == 2) return generateElseIf();
    if (type == 3) return generateElse();
    //TODO else throw exception
    return "";
  }

  private String generateIf() {
    switch (language) {
      case "py":
        return "if (" + expr + ")";
      default: /*js, java */
        return "if (" + expr + ") ";
    }
  }

  private String generateElseIf() {
    switch(language) {
      case "py":
        return "elif (" + expr + ")";
      default: /*js, java */
        return "else if (" + expr + ") ";
    }
  }

  private String generateElse() {
    switch(language) {
      case "py":
        return "else";
      default: /*js, java */
        return "else ";
    }
  }
}
