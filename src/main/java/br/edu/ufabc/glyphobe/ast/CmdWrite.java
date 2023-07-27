package br.edu.ufabc.glyphobe.ast;

public class CmdWrite extends AbstractCommand {
  
  private String text;

  public CmdWrite(String text) {
    super();
    this.text = text;
  }

  public CmdWrite() {
    super();
  }

  @Override
  public String generateCode() {
    "".substring(1, "".length());
    return "";
  }

  @Override
  public void run() {
  }
}
