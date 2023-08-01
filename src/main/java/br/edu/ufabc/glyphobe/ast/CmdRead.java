package br.edu.ufabc.glyphobe.ast;

import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;

public class CmdRead extends AbstractCommand {

  private AbstractIdentifier id;

  public CmdRead(String lang, AbstractIdentifier id) {
    super(lang);
    this.id = id;
  }

  @Override
  public String generateCode() {
    if (language == "java")
      switch(id.getType()) {
        case INTEGER:
          return id.getName() + " = scanner.nextInt();\n";
        case REAL:
          return id.getName() + " = scanner.nextFloat();\n";
        case BOOLEAN:
          return id.getName() + " = scanner.nextBoolean();\n";
        default:
          return "";
      }
    else /*js*/ return id.getName() + " = " + "prompt(\"Type your input\");\n";
  }
}
