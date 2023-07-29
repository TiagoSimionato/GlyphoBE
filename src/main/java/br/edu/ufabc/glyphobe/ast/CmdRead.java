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
    if (language == "java") return ""; /*TODO*/
    else /*js*/ return id.getName() + " = " + "prompt(\"Type your input\");\n";
  }
}
