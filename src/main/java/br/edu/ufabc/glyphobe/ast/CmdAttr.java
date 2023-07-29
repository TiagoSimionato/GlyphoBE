package br.edu.ufabc.glyphobe.ast;

import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;

public class CmdAttr extends AbstractCommand {
  private AbstractIdentifier id;
  private String expr;

  public CmdAttr(String lang, AbstractIdentifier id, String expr) {
    super(lang);
    this.id = id;
    this.expr = expr;
  }

  @Override
  public String generateCode() {
    if (language == "java") {
      return ""; //TODO
    } else { //js
      return id.getName() + " = " + expr + ";\n";
    }
  }

  public AbstractIdentifier getId() {
    return id;
  }

  public void setId(AbstractIdentifier id) {
    this.id = id;
  }
}
