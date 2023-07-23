package src.ast;

import src.symbols.identifiers.AbstractIdentifier;

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
