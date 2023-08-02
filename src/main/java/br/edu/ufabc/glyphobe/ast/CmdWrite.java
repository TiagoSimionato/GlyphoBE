package br.edu.ufabc.glyphobe.ast;

public class CmdWrite extends AbstractCommand {
  
  private String text;
  
  public CmdWrite(String lang, String text) {
    super(lang);
    this.text = text;
  }

  @Override
  public String generateCode() {
    switch(language) {
      case "java":
        return "System.out.println(" + text + ");\n";
      case "py":
        return "print(" + text + ")\n";
      default: /*js*/
        return "alert(" + text + ");\n";
    }
  }
}
