package br.edu.ufabc.glyphobe.ast;

import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;

public class CmdRead extends AbstractCommand {

  private AbstractIdentifier id;

  public CmdRead(AbstractIdentifier id) {
    super();
    this.id = id;
  }

  public CmdRead() {
    super();
  }

  @Override
  public String generateCode() {
    return "";
  }

  @Override
  public void run() {
  }
}
