package br.edu.ufabc.glyphobe.ast;

import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;

public class CmdDeclare extends AbstractCommand {
  private AbstractIdentifier id;

  public CmdDeclare(String language, AbstractIdentifier id) {
    super(language);
    this.id = id;
  }

  @Override
  public String generateCode() {
    switch (id.getType()) {
      case INTEGER:
        return generateInteger();
      case REAL:
        return generateReal();
      case BOOLEAN:
        return generateBoolean();
      default:
        return "";
    }
  }

  private String generateInteger() {
    switch (language) {
      case "java":
        return "int " + id.getName() + ";\n";
      default: 
        return "var " + id.getName() + ";\n";
    }
  }

  private String generateReal() {
    switch (language) {
      case "java":
        return "float " + id.getName() + ";\n";
      default: 
        return "var " + id.getName() + ";\n";
    }
  }

  private String generateBoolean() {
    switch (language) {
      case "java":
        return "boolean " + id.getName() + ";\n";
      default: 
        return "var " + id.getName() + ";\n";
    }
  }
}
